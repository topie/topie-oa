package com.topie.cms.persistence.domain;

// Generated by Hibernate Tools
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * CmsCatalog .
 * 
 * @author Lingo
 */
@Entity
@Table(name = "CMS_CATALOG")
public class CmsCatalog implements java.io.Serializable {
    private static final long serialVersionUID = 0L;

    /** null. */
    private Long id;

    /** null. */
    private CmsSite cmsSite;

    /** null. */
    private CmsCatalog cmsCatalog;

    /** null. */
    private String name;

    /** null. */
    private String code;

    /** null. */
    private String logo;

    /** null. */
    private Integer type;

    /** null. */
    private String templateIndex;

    /** null. */
    private String templateList;

    /** null. */
    private String templateDetail;

    /** null. */
    private String keyword;

    /** null. */
    private String description;

    /** null. */
    private String tenantId;

    /** . */
    private Set<CmsCatalog> cmsCatalogs = new HashSet<CmsCatalog>(0);

    /** . */
    private Set<CmsArticle> cmsArticles = new HashSet<CmsArticle>(0);

    public CmsCatalog() {
    }

    public CmsCatalog(Long id) {
        this.id = id;
    }

    public CmsCatalog(Long id, CmsSite cmsSite, CmsCatalog cmsCatalog,
            String name, String code, String logo, Integer type,
            String templateIndex, String templateList, String templateDetail,
            String keyword, String description, String tenantId,
            Set<CmsCatalog> cmsCatalogs, Set<CmsArticle> cmsArticles) {
        this.id = id;
        this.cmsSite = cmsSite;
        this.cmsCatalog = cmsCatalog;
        this.name = name;
        this.code = code;
        this.logo = logo;
        this.type = type;
        this.templateIndex = templateIndex;
        this.templateList = templateList;
        this.templateDetail = templateDetail;
        this.keyword = keyword;
        this.description = description;
        this.tenantId = tenantId;
        this.cmsCatalogs = cmsCatalogs;
        this.cmsArticles = cmsArticles;
    }

    /** @return null. */
    @Id
    @Column(name = "ID", unique = true, nullable = false)
    public Long getId() {
        return this.id;
    }

    /**
     * @param id
     *            null.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /** @return null. */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SITE_ID")
    public CmsSite getCmsSite() {
        return this.cmsSite;
    }

    /**
     * @param cmsSite
     *            null.
     */
    public void setCmsSite(CmsSite cmsSite) {
        this.cmsSite = cmsSite;
    }

    /** @return null. */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PARENT_ID")
    public CmsCatalog getCmsCatalog() {
        return this.cmsCatalog;
    }

    /**
     * @param cmsCatalog
     *            null.
     */
    public void setCmsCatalog(CmsCatalog cmsCatalog) {
        this.cmsCatalog = cmsCatalog;
    }

    /** @return null. */
    @Column(name = "NAME", length = 50)
    public String getName() {
        return this.name;
    }

    /**
     * @param name
     *            null.
     */
    public void setName(String name) {
        this.name = name;
    }

    /** @return null. */
    @Column(name = "CODE", length = 200)
    public String getCode() {
        return this.code;
    }

    /**
     * @param code
     *            null.
     */
    public void setCode(String code) {
        this.code = code;
    }

    /** @return null. */
    @Column(name = "LOGO", length = 200)
    public String getLogo() {
        return this.logo;
    }

    /**
     * @param logo
     *            null.
     */
    public void setLogo(String logo) {
        this.logo = logo;
    }

    /** @return null. */
    @Column(name = "TYPE")
    public Integer getType() {
        return this.type;
    }

    /**
     * @param type
     *            null.
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /** @return null. */
    @Column(name = "TEMPLATE_INDEX", length = 200)
    public String getTemplateIndex() {
        return this.templateIndex;
    }

    /**
     * @param templateIndex
     *            null.
     */
    public void setTemplateIndex(String templateIndex) {
        this.templateIndex = templateIndex;
    }

    /** @return null. */
    @Column(name = "TEMPLATE_LIST", length = 200)
    public String getTemplateList() {
        return this.templateList;
    }

    /**
     * @param templateList
     *            null.
     */
    public void setTemplateList(String templateList) {
        this.templateList = templateList;
    }

    /** @return null. */
    @Column(name = "TEMPLATE_DETAIL", length = 200)
    public String getTemplateDetail() {
        return this.templateDetail;
    }

    /**
     * @param templateDetail
     *            null.
     */
    public void setTemplateDetail(String templateDetail) {
        this.templateDetail = templateDetail;
    }

    /** @return null. */
    @Column(name = "KEYWORD", length = 200)
    public String getKeyword() {
        return this.keyword;
    }

    /**
     * @param keyword
     *            null.
     */
    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    /** @return null. */
    @Column(name = "DESCRIPTION", length = 200)
    public String getDescription() {
        return this.description;
    }

    /**
     * @param description
     *            null.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /** @return null. */
    @Column(name = "TENANT_ID", length = 64)
    public String getTenantId() {
        return this.tenantId;
    }

    /**
     * @param tenantId
     *            null.
     */
    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    /** @return . */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "cmsCatalog")
    public Set<CmsCatalog> getCmsCatalogs() {
        return this.cmsCatalogs;
    }

    /**
     * @param cmsCatalogs
     *            .
     */
    public void setCmsCatalogs(Set<CmsCatalog> cmsCatalogs) {
        this.cmsCatalogs = cmsCatalogs;
    }

    /** @return . */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "cmsCatalog")
    public Set<CmsArticle> getCmsArticles() {
        return this.cmsArticles;
    }

    /**
     * @param cmsArticles
     *            .
     */
    public void setCmsArticles(Set<CmsArticle> cmsArticles) {
        this.cmsArticles = cmsArticles;
    }
}
