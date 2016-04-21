package com.topie.portal.persistence.domain;

// Generated by Hibernate Tools
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * PortalInfo .
 * 
 * @author Lingo
 */
@Entity
@Table(name = "PORTAL_INFO")
public class PortalInfo implements java.io.Serializable {
    private static final long serialVersionUID = 0L;

    /** null. */
    private Long id;

    /** null. */
    private String name;

    /** null. */
    private String description;

    /** null. */
    private String userId;

    /** null. */
    private Date createTime;

    /** null. */
    private String columnLayout;

    /** null. */
    private String sharedStatus;

    /** null. */
    private String globalStatus;

    /** null. */
    private String tenantId;

    /** . */
    private Set<PortalItem> portalItems = new HashSet<PortalItem>(0);

    /** . */
    private Set<PortalRef> portalRefs = new HashSet<PortalRef>(0);

    public PortalInfo() {
    }

    public PortalInfo(Long id) {
        this.id = id;
    }

    public PortalInfo(Long id, String name, String description, String userId,
            Date createTime, String columnLayout, String sharedStatus,
            String globalStatus, String tenantId, Set<PortalItem> portalItems,
            Set<PortalRef> portalRefs) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.userId = userId;
        this.createTime = createTime;
        this.columnLayout = columnLayout;
        this.sharedStatus = sharedStatus;
        this.globalStatus = globalStatus;
        this.tenantId = tenantId;
        this.portalItems = portalItems;
        this.portalRefs = portalRefs;
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
    @Column(name = "NAME", length = 200)
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
    @Column(name = "USER_ID", length = 64)
    public String getUserId() {
        return this.userId;
    }

    /**
     * @param userId
     *            null.
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /** @return null. */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATE_TIME", length = 26)
    public Date getCreateTime() {
        return this.createTime;
    }

    /**
     * @param createTime
     *            null.
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /** @return null. */
    @Column(name = "COLUMN_LAYOUT", length = 100)
    public String getColumnLayout() {
        return this.columnLayout;
    }

    /**
     * @param columnLayout
     *            null.
     */
    public void setColumnLayout(String columnLayout) {
        this.columnLayout = columnLayout;
    }

    /** @return null. */
    @Column(name = "SHARED_STATUS", length = 10)
    public String getSharedStatus() {
        return this.sharedStatus;
    }

    /**
     * @param sharedStatus
     *            null.
     */
    public void setSharedStatus(String sharedStatus) {
        this.sharedStatus = sharedStatus;
    }

    /** @return null. */
    @Column(name = "GLOBAL_STATUS", length = 10)
    public String getGlobalStatus() {
        return this.globalStatus;
    }

    /**
     * @param globalStatus
     *            null.
     */
    public void setGlobalStatus(String globalStatus) {
        this.globalStatus = globalStatus;
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
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "portalInfo")
    public Set<PortalItem> getPortalItems() {
        return this.portalItems;
    }

    /**
     * @param portalItems
     *            .
     */
    public void setPortalItems(Set<PortalItem> portalItems) {
        this.portalItems = portalItems;
    }

    /** @return . */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "portalInfo")
    public Set<PortalRef> getPortalRefs() {
        return this.portalRefs;
    }

    /**
     * @param portalRefs
     *            .
     */
    public void setPortalRefs(Set<PortalRef> portalRefs) {
        this.portalRefs = portalRefs;
    }
}
