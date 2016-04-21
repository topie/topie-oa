package com.topie.cms.web;

import java.util.List;

import javax.annotation.Resource;

import com.topie.api.tenant.TenantHolder;

import com.topie.cms.persistence.domain.CmsArticle;
import com.topie.cms.persistence.domain.CmsCatalog;
import com.topie.cms.persistence.manager.CmsArticleManager;
import com.topie.cms.persistence.manager.CmsCatalogManager;
import com.topie.cms.service.RenderService;

import com.topie.core.export.Exportor;
import com.topie.core.mapper.BeanMapper;
import com.topie.core.spring.MessageHelper;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("cms")
public class CmsController {
    private CmsArticleManager cmsArticleManager;
    private CmsCatalogManager cmsCatalogManager;
    private Exportor exportor;
    private BeanMapper beanMapper = new BeanMapper();
    private MessageHelper messageHelper;
    private RenderService renderService;
    private TenantHolder tenantHolder;

    @RequestMapping("index")
    public String index(Model model) {
        String tenantId = tenantHolder.getTenantId();
        List<CmsCatalog> cmsCatalogs = cmsCatalogManager.findBy("tenantId",
                tenantId);
        String html = renderService.viewIndex(cmsCatalogs);

        model.addAttribute("html", html);

        return "cms/index";
    }

    @RequestMapping("catalog")
    public String catalog(@RequestParam("id") Long id, Model model) {
        CmsCatalog cmsCatalog = cmsCatalogManager.get(id);
        String html = renderService.viewCatalog(cmsCatalog);
        model.addAttribute("html", html);

        return "cms/catalog";
    }

    @RequestMapping("article")
    public String article(@RequestParam("id") Long id, Model model) {
        CmsArticle cmsArticle = cmsArticleManager.get(id);
        String html = renderService.viewArticle(cmsArticle);

        model.addAttribute("html", html);

        return "cms/article";
    }

    @RequestMapping("export")
    public String export(Model model) {
        return "cms/export";
    }

    // ~ ======================================================================
    @Resource
    public void setCmsArticleManager(CmsArticleManager cmsArticleManager) {
        this.cmsArticleManager = cmsArticleManager;
    }

    @Resource
    public void setCmsCatalogManager(CmsCatalogManager cmsCatalogManager) {
        this.cmsCatalogManager = cmsCatalogManager;
    }

    @Resource
    public void setExportor(Exportor exportor) {
        this.exportor = exportor;
    }

    @Resource
    public void setMessageHelper(MessageHelper messageHelper) {
        this.messageHelper = messageHelper;
    }

    @Resource
    public void setRenderService(RenderService renderService) {
        this.renderService = renderService;
    }

    @Resource
    public void setTenantHolder(TenantHolder tenantHolder) {
        this.tenantHolder = tenantHolder;
    }
}
