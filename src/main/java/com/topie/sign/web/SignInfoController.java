package com.topie.sign.web;

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

import com.topie.sign.persistence.domain.SignInfo;
import com.topie.sign.persistence.manager.SignInfoManager;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("sign")
public class SignInfoController {
    private SignInfoManager signInfoManager;
    private Exportor exportor;
    private BeanMapper beanMapper = new BeanMapper();
    private UserConnector userConnector;
    private MessageHelper messageHelper;
    private TenantHolder tenantHolder;

    @RequestMapping("sign-info-list")
    public String list(@ModelAttribute Page page,
            @RequestParam Map<String, Object> parameterMap, Model model) {
        String tenantId = tenantHolder.getTenantId();
        List<PropertyFilter> propertyFilters = PropertyFilter
                .buildFromMap(parameterMap);
        propertyFilters.add(new PropertyFilter("EQS_tenantId", tenantId));
        page = signInfoManager.pagedQuery(page, propertyFilters);

        model.addAttribute("page", page);

        return "sign/sign-info-list";
    }

    @RequestMapping("sign-info-input")
    public String input(@RequestParam(value = "id", required = false) Long id,
            Model model) {
        if (id != null) {
            SignInfo signInfo = signInfoManager.get(id);
            model.addAttribute("model", signInfo);
        }

        return "sign/sign-info-input";
    }

    @RequestMapping("sign-info-save")
    public String save(@ModelAttribute SignInfo signInfo,
            @RequestParam Map<String, Object> parameterMap,
            RedirectAttributes redirectAttributes) {
        String tenantId = tenantHolder.getTenantId();
        SignInfo dest = null;

        Long id = signInfo.getId();

        if (id != null) {
            dest = signInfoManager.get(id);
            beanMapper.copy(signInfo, dest);
        } else {
            dest = signInfo;
            dest.setTenantId(tenantId);
        }

        signInfoManager.save(dest);

        messageHelper.addFlashMessage(redirectAttributes, "core.success.save",
                "保存成功");

        return "redirect:/sign/sign-info-list.do";
    }

    @RequestMapping("sign-info-remove")
    public String remove(@RequestParam("selectedItem") List<Long> selectedItem,
            RedirectAttributes redirectAttributes) {
        List<SignInfo> signInfos = signInfoManager.findByIds(selectedItem);

        signInfoManager.removeAll(signInfos);

        messageHelper.addFlashMessage(redirectAttributes,
                "core.success.delete", "删除成功");

        return "redirect:/sign/sign-info-list.do";
    }

    @RequestMapping("sign-info-export")
    public void export(@ModelAttribute Page page,
            @RequestParam Map<String, Object> parameterMap,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        String tenantId = tenantHolder.getTenantId();
        List<PropertyFilter> propertyFilters = PropertyFilter
                .buildFromMap(parameterMap);
        propertyFilters.add(new PropertyFilter("EQS_tenantId", tenantId));
        page = signInfoManager.pagedQuery(page, propertyFilters);

        List<SignInfo> signInfos = (List<SignInfo>) page.getResult();

        TableModel tableModel = new TableModel();
        tableModel.setName("sign info");
        tableModel.addHeaders("id", "name");
        tableModel.setData(signInfos);
        exportor.export(request, response, tableModel);
    }

    // ~ ======================================================================
    @Resource
    public void setSignInfoManager(SignInfoManager signInfoManager) {
        this.signInfoManager = signInfoManager;
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
