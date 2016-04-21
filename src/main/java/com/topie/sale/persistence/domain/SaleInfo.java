package com.topie.sale.persistence.domain;

// Generated by Hibernate Tools
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * SaleInfo .
 * 
 * @author Lingo
 */
@Entity
@Table(name = "SALE_INFO")
public class SaleInfo implements java.io.Serializable {
    private static final long serialVersionUID = 0L;

    /** null. */
    private Long id;

    /** null. */
    private String name;

    /** null. */
    private Date createTime;

    /** null. */
    private String status;

    /** null. */
    private String customer;

    /** null. */
    private String product;

    /** null. */
    private String description;

    /** null. */
    private String userId;

    /** null. */
    private String tenantId;

    public SaleInfo() {
    }

    public SaleInfo(Long id) {
        this.id = id;
    }

    public SaleInfo(Long id, String name, Date createTime, String status,
            String customer, String product, String description, String userId,
            String tenantId) {
        this.id = id;
        this.name = name;
        this.createTime = createTime;
        this.status = status;
        this.customer = customer;
        this.product = product;
        this.description = description;
        this.userId = userId;
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
    @Column(name = "CUSTOMER", length = 100)
    public String getCustomer() {
        return this.customer;
    }

    /**
     * @param customer
     *            null.
     */
    public void setCustomer(String customer) {
        this.customer = customer;
    }

    /** @return null. */
    @Column(name = "PRODUCT", length = 100)
    public String getProduct() {
        return this.product;
    }

    /**
     * @param product
     *            null.
     */
    public void setProduct(String product) {
        this.product = product;
    }

    /** @return null. */
    @Column(name = "DESCRIPTION", length = 65535)
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
