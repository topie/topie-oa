package com.topie.seat.web;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.topie.api.tenant.TenantHolder;
import com.topie.api.user.UserConnector;

import com.topie.core.export.Exportor;
import com.topie.core.export.TableModel;
import com.topie.core.mapper.BeanMapper;
import com.topie.core.page.Page;
import com.topie.core.query.PropertyFilter;
import com.topie.core.spring.MessageHelper;

import com.topie.seat.persistence.domain.SeatInfo;
import com.topie.seat.persistence.manager.SeatInfoManager;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("seat")
public class SeatInfoController {
    private SeatInfoManager seatInfoManager;
    private Exportor exportor;
    private BeanMapper beanMapper = new BeanMapper();
    private UserConnector userConnector;
    private MessageHelper messageHelper;
    private TenantHolder tenantHolder;

    @RequestMapping("seat-info-list")
    public String list(@ModelAttribute Page page,
            @RequestParam Map<String, Object> parameterMap, Model model) {
        String tenantId = tenantHolder.getTenantId();
        List<PropertyFilter> propertyFilters = PropertyFilter
                .buildFromMap(parameterMap);
        propertyFilters.add(new PropertyFilter("EQS_tenantId", tenantId));
        page = seatInfoManager.pagedQuery(page, propertyFilters);

        model.addAttribute("page", page);

        return "seat/seat-info-list";
    }

    @RequestMapping("seat-info-input")
    public String input(@RequestParam(value = "id", required = false) Long id,
            Model model) {
        if (id != null) {
            SeatInfo seatInfo = seatInfoManager.get(id);
            model.addAttribute("model", seatInfo);
        }

        return "seat/seat-info-input";
    }

    @RequestMapping("seat-info-save")
    public String save(@ModelAttribute SeatInfo seatInfo,
            @RequestParam Map<String, Object> parameterMap,
            RedirectAttributes redirectAttributes) {
        String tenantId = tenantHolder.getTenantId();
        SeatInfo dest = null;

        Long id = seatInfo.getId();

        if (id != null) {
            dest = seatInfoManager.get(id);
            beanMapper.copy(seatInfo, dest);
        } else {
            dest = seatInfo;
            dest.setTenantId(tenantId);
        }

        seatInfoManager.save(dest);

        messageHelper.addFlashMessage(redirectAttributes, "core.success.save",
                "保存成功");

        return "redirect:/seat/seat-info-list.do";
    }

    @RequestMapping("seat-info-remove")
    public String remove(@RequestParam("selectedItem") List<Long> selectedItem,
            RedirectAttributes redirectAttributes) {
        List<SeatInfo> seatInfos = seatInfoManager.findByIds(selectedItem);

        seatInfoManager.removeAll(seatInfos);

        messageHelper.addFlashMessage(redirectAttributes,
                "core.success.delete", "删除成功");

        return "redirect:/seat/seat-info-list.do";
    }

    @RequestMapping("seat-info-export")
    public void export(@ModelAttribute Page page,
            @RequestParam Map<String, Object> parameterMap,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        String tenantId = tenantHolder.getTenantId();
        List<PropertyFilter> propertyFilters = PropertyFilter
                .buildFromMap(parameterMap);
        propertyFilters.add(new PropertyFilter("EQS_tenantId", tenantId));
        page = seatInfoManager.pagedQuery(page, propertyFilters);

        List<SeatInfo> seatInfos = (List<SeatInfo>) page.getResult();

        TableModel tableModel = new TableModel();
        tableModel.setName("seat info");
        tableModel.addHeaders("id", "name");
        tableModel.setData(seatInfos);
        exportor.export(request, response, tableModel);
    }

    // ~ ======================================================================
    @Resource
    public void setSeatInfoManager(SeatInfoManager seatInfoManager) {
        this.seatInfoManager = seatInfoManager;
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
}
