package com.topie.user.web;

import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.topie.api.tenant.TenantHolder;
import com.topie.api.user.UserConnector;
import com.topie.core.export.Exportor;
import com.topie.core.export.TableModel;
import com.topie.core.mapper.BeanMapper;
import com.topie.core.page.Page;
import com.topie.core.query.PropertyFilter;
import com.topie.core.spring.MessageHelper;
import com.topie.user.persistence.domain.AccountAttendance;
import com.topie.user.persistence.domain.AccountInfo;
import com.topie.user.persistence.manager.AccountAttendanceManager;
import com.topie.user.persistence.manager.AccountInfoManager;

@Controller
@RequestMapping("user")
public class AccountAttendanceController {
    private AccountAttendanceManager accountAttendanceManager;
    private AccountInfoManager accountInfoManager;
	private Exportor exportor;
    private BeanMapper beanMapper = new BeanMapper();
    private UserConnector userConnector;
    private MessageHelper messageHelper;
    private TenantHolder tenantHolder;
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm");
    private String defaultStartTime = "14:00";
    private String defaultEndTime = "12:00";

    @RequestMapping("account-attendance-list")
    public String list(@ModelAttribute Page page,
            Long userId, String dateStr, Model model) {
        String tenantId = tenantHolder.getTenantId();
        List<PropertyFilter> propertyFilters = new ArrayList<PropertyFilter>();
        
        if(userId != null && userId > 0){
        	AccountInfo account = accountInfoManager.get(userId);
        	String hql = "from AccountAttendance where accountInfo=? order by dateStr desc";
        	List<AccountAttendance> list = null;
        	if(StringUtils.isEmpty(dateStr)){
        		list = accountAttendanceManager.find(hql, account);
        	}else{
        		hql = "from AccountAttendance where accountInfo=? and dateStr=?";
        		list = accountAttendanceManager.find(hql, account,dateStr);
        	}
        	model.addAttribute("list", list);
        	return "user/account-attendance-self";
        }
        //默认查询当天的考勤
        if(StringUtils.isEmpty(dateStr)){
        	dateStr = format.format(new Date());
        }
        propertyFilters.add(new PropertyFilter("EQS_dateStr", dateStr));
        propertyFilters.add(new PropertyFilter("EQS_tenantId", tenantId));
        page = accountAttendanceManager.pagedQuery(page, propertyFilters);

        model.addAttribute("page", page);

        return "user/account-attendance-list";
    }

    @RequestMapping("account-attendance-input")
    public String input(@RequestParam(value = "id", required = false) Long id,
            Model model) {
        if (id != null) {
            AccountAttendance attendanceInfo = accountAttendanceManager.get(id);
            model.addAttribute("model", attendanceInfo);
        }

        return "user/account-attendance-input";
    }

    
    @RequestMapping("accountAttendanceSave")
    public void save(HttpServletResponse response,Long userId,String workStartTime,String workEndTime){
    	response.setContentType("text/html;charset=UTF-8");
		AccountAttendance attendance = new AccountAttendance();
		PrintWriter out = null;
		try {
			AccountInfo accountInfo = accountInfoManager.get(userId);
			attendance.setAccountInfo(accountInfo);
			if(workStartTime != null){
				attendance.setWorkStartTime(workStartTime);
			}
			if(workEndTime != null){
				attendance.setWorkEndTime(workEndTime);
			}
			attendance.setDateStr(format.format(new Date()));
			attendance.setWeekStr(getWeekOfDate(new Date()));
			attendance.setVacation((byte)0);
			attendance.setIsDays((byte)1);
			attendance.setShouldAttendance(8f);
			attendance.setRealAttendance(8f);
			accountAttendanceManager.save(attendance);
			out = response.getWriter();
			out.println();
			out.flush();
			out.close();
		} catch (Exception e) {
			out.write("error");
			out.flush();
			out.close();
		}
    }
    
    
    @RequestMapping("account-attendance-save")
	public String save(@ModelAttribute AccountAttendance attendanceInfo,
			Long userId, @RequestParam Map<String, Object> parameterMap,
			RedirectAttributes redirectAttributes) {
        String tenantId = tenantHolder.getTenantId();
        AccountAttendance dest = null;

        Long id = attendanceInfo.getId();

        if (id != null) {
            dest = accountAttendanceManager.get(id);
            beanMapper.copy(attendanceInfo, dest);
        } else {
            dest = attendanceInfo;
            dest.setTenantId(tenantId);
            AccountInfo accountInfo = accountInfoManager.get(userId);
            dest.setAccountInfo(accountInfo);
        }
        try {
			Date dateStr = format.parse(attendanceInfo.getDateStr());
			dest.setWeekStr(getWeekOfDate(dateStr));
		} catch (ParseException e) {
			e.printStackTrace();
		}
        accountAttendanceManager.save(dest);

        messageHelper.addFlashMessage(redirectAttributes, "core.success.save",
                "保存成功");

        return "redirect:/user/account-attendance-list.do?userId="+userId;
    }
    

    @RequestMapping("account-attendance-remove")
    public String remove(@RequestParam("selectedItem") List<Long> selectedItem,
            RedirectAttributes redirectAttributes) {
        List<AccountAttendance> attendanceInfos = accountAttendanceManager
                .findByIds(selectedItem);

        accountAttendanceManager.removeAll(attendanceInfos);

        messageHelper.addFlashMessage(redirectAttributes,
                "core.success.delete", "删除成功");

        return "redirect:/user/account-attendance-list.do";
    }

    @RequestMapping("account-attendance-export")
    public void export(@ModelAttribute Page page,
            @RequestParam Map<String, Object> parameterMap,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        String tenantId = tenantHolder.getTenantId();
        List<PropertyFilter> propertyFilters = PropertyFilter
                .buildFromMap(parameterMap);
        propertyFilters.add(new PropertyFilter("EQS_tenantId", tenantId));
        page = accountAttendanceManager.pagedQuery(page, propertyFilters);

        List<AccountAttendance> attendanceInfos = (List<AccountAttendance>) page
                .getResult();

        TableModel tableModel = new TableModel();
        tableModel.setName("attendance info");
        tableModel.addHeaders("id", "name");
        tableModel.setData(attendanceInfos);
        exportor.export(request, response, tableModel);
    }

    //获取当前是星期几
    public static String getWeekOfDate(Date date) {      
        String[] weekOfDays = {"日", "一", "二", "三", "四", "五", "六"};        
        Calendar calendar = Calendar.getInstance();      
        if(date != null){        
             calendar.setTime(date);      
        }        
        int w = calendar.get(Calendar.DAY_OF_WEEK) - 1;      
        if (w < 0){        
            w = 0;      
        }      
        return weekOfDays[w];    
    }
    
    //计算实际出勤
//    public float getRealWorkTime(String workStartTime,String workEndTime){
//    	if(StringUtils.isEmpty(workStartTime) && StringUtils.isEmpty(workEndTime)){
//    		return 0f;
//    	}
//    	if(StringUtils.isEmpty(workStartTime)){
//    		workStartTime = this.defaultStartTime;
//    	}
//    	if(StringUtils.isEmpty(workEndTime)){
//    		workEndTime = defaultEndTime;
//    	}
//    }
    
    // ~ ======================================================================
    @Resource
    public void setAttendanceInfoManager(
            AccountAttendanceManager attendanceInfoManager) {
        this.accountAttendanceManager = attendanceInfoManager;
    }

    @Resource
    public void setExportor(Exportor exportor) {
        this.exportor = exportor;
    }

    @Resource
    public void setUserConnector(UserConnector userConnector) {
        this.userConnector = userConnector;
    }

    @Resource
    public void setMessageHelper(MessageHelper messageHelper) {
        this.messageHelper = messageHelper;
    }

    @Resource
    public void setTenantHolder(TenantHolder tenantHolder) {
        this.tenantHolder = tenantHolder;
    }
    
    @Resource
    public void setAccountInfoManager(AccountInfoManager accountInfoManager) {
		this.accountInfoManager = accountInfoManager;
	}
}
