package com.topie.user.web;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.topie.core.export.Exportor;
import com.topie.core.mapper.BeanMapper;
import com.topie.core.page.Page;
import com.topie.core.query.PropertyFilter;
import com.topie.core.spring.MessageHelper;

import com.topie.user.persistence.manager.AccountLockLogManager;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("user")
public class AccountLockLogController {
    private AccountLockLogManager accountLockLogManager;
    private Exportor exportor;
    private BeanMapper beanMapper = new BeanMapper();
    private MessageHelper messageHelper;

    @RequestMapping("account-lock-log-list")
    public String list(@ModelAttribute Page page,
            @RequestParam Map<String, Object> parameterMap, Model model) {
        page.setDefaultOrder("lockTime", "DESC");

        List<PropertyFilter> propertyFilters = PropertyFilter
                .buildFromMap(parameterMap);
        page = accountLockLogManager.pagedQuery(page, propertyFilters);

        model.addAttribute("page", page);

        return "user/account-lock-log-list";
    }

    // ~ ======================================================================
    @Resource
    public void setAccountLockLogManager(
            AccountLockLogManager accountLockLogManager) {
        this.accountLockLogManager = accountLockLogManager;
    }

    @Resource
    public void setExportor(Exportor exportor) {
        this.exportor = exportor;
    }

    @Resource
    public void setMessageHelper(MessageHelper messageHelper) {
        this.messageHelper = messageHelper;
    }
}
