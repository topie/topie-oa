package com.topie.user.persistence.domain;

// Generated by Hibernate Tools
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * AccountDevice .
 * 
 * @author Lingo
 */
@Entity
@Table(name = "ACCOUNT_DEVICE")
public class AccountDevice implements java.io.Serializable {
    private static final long serialVersionUID = 0L;

    /** null. */
    private Long id;

    /** null. */
    private AccountInfo accountInfo;

    /** null. */
    private String code;

    /** null. */
    private String type;

    /** null. */
    private String os;

    /** null. */
    private String client;

    /** null. */
    private String status;

    /** null. */
    private Date createTime;

    /** null. */
    private Date lastLoginTime;

    /** null. */
    private String attribute1;

    /** null. */
    private String tenantId;

    public AccountDevice() {
    }

    public AccountDevice(Long id) {
        this.id = id;
    }

    public AccountDevice(Long id, AccountInfo accountInfo, String code,
            String type, String os, String client, String status,
            Date createTime, Date lastLoginTime, String attribute1,
            String tenantId) {
        this.id = id;
        this.accountInfo = accountInfo;
        this.code = code;
        this.type = type;
        this.os = os;
        this.client = client;
        this.status = status;
        this.createTime = createTime;
        this.lastLoginTime = lastLoginTime;
        this.attribute1 = attribute1;
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
    @JoinColumn(name = "ACCOUNT_ID")
    public AccountInfo getAccountInfo() {
        return this.accountInfo;
    }

    /**
     * @param accountInfo
     *            null.
     */
    public void setAccountInfo(AccountInfo accountInfo) {
        this.accountInfo = accountInfo;
    }

    /** @return null. */
    @Column(name = "CODE", length = 64)
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
    @Column(name = "TYPE", length = 64)
    public String getType() {
        return this.type;
    }

    /**
     * @param type
     *            null.
     */
    public void setType(String type) {
        this.type = type;
    }

    /** @return null. */
    @Column(name = "OS", length = 100)
    public String getOs() {
        return this.os;
    }

    /**
     * @param os
     *            null.
     */
    public void setOs(String os) {
        this.os = os;
    }

    /** @return null. */
    @Column(name = "CLIENT", length = 100)
    public String getClient() {
        return this.client;
    }

    /**
     * @param client
     *            null.
     */
    public void setClient(String client) {
        this.client = client;
    }

    /** @return null. */
    @Column(name = "STATUS", length = 50)
    public String getStatus() {
        return this.status;
    }

    /**
     * @param status
     *            null.
     */
    public void setStatus(String status) {
        this.status = status;
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
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "LAST_LOGIN_TIME", length = 26)
    public Date getLastLoginTime() {
        return this.lastLoginTime;
    }

    /**
     * @param lastLoginTime
     *            null.
     */
    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    /** @return null. */
    @Column(name = "ATTRIBUTE1", length = 200)
    public String getAttribute1() {
        return this.attribute1;
    }

    /**
     * @param attribute1
     *            null.
     */
    public void setAttribute1(String attribute1) {
        this.attribute1 = attribute1;
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
