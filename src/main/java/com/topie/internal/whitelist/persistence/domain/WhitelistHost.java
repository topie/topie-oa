package com.topie.internal.whitelist.persistence.domain;

// Generated by Hibernate Tools
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * WhitelistHost .
 * 
 * @author Lingo
 */
@Entity
@Table(name = "WHITELIST_HOST")
public class WhitelistHost implements java.io.Serializable {
    private static final long serialVersionUID = 0L;

    /** null. */
    private Long id;

    /** null. */
    private WhitelistApp whitelistApp;

    /** null. */
    private String value;

    /** null. */
    private Integer priority;

    /** null. */
    private String tenantId;

    public WhitelistHost() {
    }

    public WhitelistHost(Long id) {
        this.id = id;
    }

    public WhitelistHost(Long id, WhitelistApp whitelistApp, String value,
            Integer priority, String tenantId) {
        this.id = id;
        this.whitelistApp = whitelistApp;
        this.value = value;
        this.priority = priority;
        this.tenantId = tenantId;
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
    @JoinColumn(name = "APP_ID")
    public WhitelistApp getWhitelistApp() {
        return this.whitelistApp;
    }

    /**
     * @param whitelistApp
     *            null.
     */
    public void setWhitelistApp(WhitelistApp whitelistApp) {
        this.whitelistApp = whitelistApp;
    }

    /** @return null. */
    @Column(name = "VALUE", length = 50)
    public String getValue() {
        return this.value;
    }

    /**
     * @param value
     *            null.
     */
    public void setValue(String value) {
        this.value = value;
    }

    /** @return null. */
    @Column(name = "PRIORITY")
    public Integer getPriority() {
        return this.priority;
    }

    /**
     * @param priority
     *            null.
     */
    public void setPriority(Integer priority) {
        this.priority = priority;
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
}
