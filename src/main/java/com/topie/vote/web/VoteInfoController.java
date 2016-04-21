package com.topie.vote.web;

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

import com.topie.vote.persistence.domain.VoteInfo;
import com.topie.vote.persistence.manager.VoteInfoManager;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("vote")
public class VoteInfoController {
    private VoteInfoManager voteInfoManager;
    private Exportor exportor;
    private BeanMapper beanMapper = new BeanMapper();
    private UserConnector userConnector;
    private MessageHelper messageHelper;
    private TenantHolder tenantHolder;

    @RequestMapping("vote-info-list")
    public String list(@ModelAttribute Page page,
            @RequestParam Map<String, Object> parameterMap, Model model) {
        String tenantId = tenantHolder.getTenantId();
        List<PropertyFilter> propertyFilters = PropertyFilter
                .buildFromMap(parameterMap);
        propertyFilters.add(new PropertyFilter("EQS_tenantId", tenantId));
        page = voteInfoManager.pagedQuery(page, propertyFilters);

        model.addAttribute("page", page);

        return "vote/vote-info-list";
    }

    @RequestMapping("vote-info-input")
    public String input(@RequestParam(value = "id", required = false) Long id,
            Model model) {
        if (id != null) {
            VoteInfo voteInfo = voteInfoManager.get(id);
            model.addAttribute("model", voteInfo);
        }

        return "vote/vote-info-input";
    }

    @RequestMapping("vote-info-save")
    public String save(@ModelAttribute VoteInfo voteInfo,
            @RequestParam Map<String, Object> parameterMap,
            RedirectAttributes redirectAttributes) {
        String tenantId = tenantHolder.getTenantId();
        VoteInfo dest = null;

        Long id = voteInfo.getId();

        if (id != null) {
            dest = voteInfoManager.get(id);
            beanMapper.copy(voteInfo, dest);
        } else {
            dest = voteInfo;
            dest.setTenantId(tenantId);
        }

        voteInfoManager.save(dest);

        messageHelper.addFlashMessage(redirectAttributes, "core.success.save",
                "保存成功");

        return "redirect:/vote/vote-info-list.do";
    }

    @RequestMapping("vote-info-remove")
    public String remove(@RequestParam("selectedItem") List<Long> selectedItem,
            RedirectAttributes redirectAttributes) {
        List<VoteInfo> voteInfos = voteInfoManager.findByIds(selectedItem);

        voteInfoManager.removeAll(voteInfos);

        messageHelper.addFlashMessage(redirectAttributes,
                "core.success.delete", "删除成功");

        return "redirect:/vote/vote-info-list.do";
    }

    @RequestMapping("vote-info-export")
    public void export(@ModelAttribute Page page,
            @RequestParam Map<String, Object> parameterMap,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        String tenantId = tenantHolder.getTenantId();
        List<PropertyFilter> propertyFilters = PropertyFilter
                .buildFromMap(parameterMap);
        propertyFilters.add(new PropertyFilter("EQS_tenantId", tenantId));
        page = voteInfoManager.pagedQuery(page, propertyFilters);

        List<VoteInfo> voteInfos = (List<VoteInfo>) page.getResult();

        TableModel tableModel = new TableModel();
        tableModel.setName("vote info");
        tableModel.addHeaders("id", "name");
        tableModel.setData(voteInfos);
        exportor.export(request, response, tableModel);
    }

    // ~ ======================================================================
    @Resource
    public void setVoteInfoManager(VoteInfoManager voteInfoManager) {
        this.voteInfoManager = voteInfoManager;
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
