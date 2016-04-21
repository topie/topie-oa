package com.topie.user.persistence.domain;

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
 * AccountInfo 账号信息.
 * 
 * @author Lingo
 */
@Entity
@Table(name = "ACCOUNT_INFO")
public class AccountInfo implements java.io.Serializable {
    private static final long serialVersionUID = 0L;

    /** 主键. */
    private Long id;

    /** 用户标识. */
    private String code;

    /** 账号. */
    private String username;

    /** 类型. */
    private String type;

    /** 显示名. */
    private String displayName;

    /** 状态. */
    private String status;

    /** 是否需要密码. */
    private String passwordRequired;

    /** 是否被锁定. */
    private String locked;

    /** 创建时间. */
    private Date createTime;

    /** 关闭时间. */
    private Date closeTime;

    /** 登录时间. */
    private Date loginTime;

    /** 昵称. */
    private String nickName;

    /** 备注. */
    private String description;

    /** 语言. */
    private String language;

    /** 时区. */
    private String timezone;

    /** 租户. */
    private String tenantId;

    /** . */
    private Set<AccountCredential> accountCredentials = new HashSet<AccountCredential>(
            0);

    /** . */
    private Set<AccountDevice> accountDevices = new HashSet<AccountDevice>(0);

    /** . */
    private Set<AccountAvatar> accountAvatars = new HashSet<AccountAvatar>(0);

    public AccountInfo() {
    }

    public AccountInfo(Long id) {
        this.id = id;
    }

    public AccountInfo(Long id, String code, String username, String type,
            String displayName, String status, String passwordRequired,
            String locked, Date createTime, Date closeTime, Date loginTime,
            String nickName, String description, String language,
            String timezone, String tenantId,
            Set<AccountCredential> accountCredentials,
            Set<AccountDevice> accountDevices, Set<AccountAvatar> accountAvatars) {
        this.id = id;
        this.code = code;
        this.username = username;
        this.type = type;
        this.displayName = displayName;
        this.status = status;
        this.passwordRequired = passwordRequired;
        this.locked = locked;
        this.createTime = createTime;
        this.closeTime = closeTime;
        this.loginTime = loginTime;
        this.nickName = nickName;
        this.description = description;
        this.language = language;
        this.timezone = timezone;
        this.tenantId = tenantId;
        this.accountCredentials = accountCredentials;
        this.accountDevices = accountDevices;
        this.accountAvatars = accountAvatars;
    }

    /** @return 主键. */
    @Id
    @Column(name = "ID", unique = true, nullable = false)
    public Long getId() {
        return this.id;
    }

    /**
     * @param id
     *            主键.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /** @return 用户标识. */
    @Column(name = "CODE", length = 50)
    public String getCode() {
        return this.code;
    }

    /**
     * @param code
     *            用户标识.
     */
    public void setCode(String code) {
        this.code = code;
    }

    /** @return 账号. */
    @Column(name = "USERNAME", length = 50)
    public String getUsername() {
        return this.username;
    }

    /**
     * @param username
     *            账号.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /** @return 类型. */
    @Column(name = "TYPE", length = 50)
    public String getType() {
        return this.type;
    }

    /**
     * @param type
     *            类型.
     */
    public void setType(String type) {
        this.type = type;
    }

    /** @return 显示名. */
    @Column(name = "DISPLAY_NAME", length = 200)
    public String getDisplayName() {
        return this.displayName;
    }

    /**
     * @param displayName
     *            显示名.
     */
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    /** @return 状态. */
    @Column(name = "STATUS", length = 50)
    public String getStatus() {
        return this.status;
    }

    /**
     * @param status
     *            状态.
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /** @return 是否需要密码. */
    @Column(name = "PASSWORD_REQUIRED", length = 50)
    public String getPasswordRequired() {
        return this.passwordRequired;
    }

    /**
     * @param passwordRequired
     *            是否需要密码.
     */
    public void setPasswordRequired(String passwordRequired) {
        this.passwordRequired = passwordRequired;
    }

    /** @return 是否被锁定. */
    @Column(name = "LOCKED", length = 50)
    public String getLocked() {
        return this.locked;
    }

    /**
     * @param locked
     *            是否被锁定.
     */
    public void setLocked(String locked) {
        this.locked = locked;
    }

    /** @return 创建时间. */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATE_TIME", length = 26)
    public Date getCreateTime() {
        return this.createTime;
    }

    /**
     * @param createTime
     *            创建时间.
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /** @return 关闭时间. */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CLOSE_TIME", length = 26)
    public Date getCloseTime() {
        return this.closeTime;
    }

    /**
     * @param closeTime
     *            关闭时间.
     */
    public void setCloseTime(Date closeTime) {
        this.closeTime = closeTime;
    }

    /** @return 登录时间. */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "LOGIN_TIME", length = 26)
    public Date getLoginTime() {
        return this.loginTime;
    }

    /**
     * @param loginTime
     *            登录时间.
     */
    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    /** @return 昵称. */
    @Column(name = "NICK_NAME", length = 200)
    public String getNickName() {
        return this.nickName;
    }

    /**
     * @param nickName
     *            昵称.
     */
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    /** @return 备注. */
    @Column(name = "DESCRIPTION", length = 200)
    public String getDescription() {
        return this.description;
    }

    /**
     * @param description
     *            备注.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /** @return 语言. */
    @Column(name = "LANGUAGE", length = 50)
    public String getLanguage() {
        return this.language;
    }

    /**
     * @param language
     *            语言.
     */
    public void setLanguage(String language) {
        this.language = language;
    }

    /** @return 时区. */
    @Column(name = "TIMEZONE", length = 50)
    public String getTimezone() {
        return this.timezone;
    }

    /**
     * @param timezone
     *            时区.
     */
    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    /** @return 租户. */
    @Column(name = "TENANT_ID", length = 64)
    public String getTenantId() {
        return this.tenantId;
    }

    /**
     * @param tenantId
     *            租户.
     */
    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    /** @return . */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "accountInfo")
    public Set<AccountCredential> getAccountCredentials() {
        return this.accountCredentials;
    }

    /**
     * @param accountCredentials
     *            .
     */
    public void setAccountCredentials(Set<AccountCredential> accountCredentials) {
        this.accountCredentials = accountCredentials;
    }

    /** @return . */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "accountInfo")
    public Set<AccountDevice> getAccountDevices() {
        return this.accountDevices;
    }

    /**
     * @param accountDevices
     *            .
     */
    public void setAccountDevices(Set<AccountDevice> accountDevices) {
        this.accountDevices = accountDevices;
    }

    /** @return . */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "accountInfo")
    public Set<AccountAvatar> getAccountAvatars() {
        return this.accountAvatars;
    }

    /**
     * @param accountAvatars
     *            .
     */
    public void setAccountAvatars(Set<AccountAvatar> accountAvatars) {
        this.accountAvatars = accountAvatars;
    }
}
