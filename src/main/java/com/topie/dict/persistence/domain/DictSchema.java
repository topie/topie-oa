package com.topie.dict.persistence.domain;

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
 * DictSchema 数据字典.
 * 
 * @author Lingo
 */
@Entity
@Table(name = "DICT_SCHEMA")
public class DictSchema implements java.io.Serializable {
    private static final long serialVersionUID = 0L;

    /** 唯一主键. */
    private Long id;

    /** 外键，DICT_TYPE. */
    private DictType dictType;

    /** 名称. */
    private String name;

    /** 类型. */
    private String type;

    /** 排序. */
    private Integer priority;

    /** 描述. */
    private String descn;

    /** null. */
    private String tenantId;

    /** . */
    private Set<DictData> dictDatas = new HashSet<DictData>(0);

    public DictSchema() {
    }

    public DictSchema(Long id) {
        this.id = id;
    }

    public DictSchema(Long id, DictType dictType, String name, String type,
            Integer priority, String descn, String tenantId,
            Set<DictData> dictDatas) {
        this.id = id;
        this.dictType = dictType;
        this.name = name;
        this.type = type;
        this.priority = priority;
        this.descn = descn;
        this.tenantId = tenantId;
        this.dictDatas = dictDatas;
    }

    /** @return 唯一主键. */
    @Id
    @Column(name = "ID", unique = true, nullable = false)
    public Long getId() {
        return this.id;
    }

    /**
     * @param id
     *            唯一主键.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /** @return 外键，DICT_TYPE. */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TYPE_ID")
    public DictType getDictType() {
        return this.dictType;
    }

    /**
     * @param dictType
     *            外键，DICT_TYPE.
     */
    public void setDictType(DictType dictType) {
        this.dictType = dictType;
    }

    /** @return 名称. */
    @Column(name = "NAME", length = 200)
    public String getName() {
        return this.name;
    }

    /**
     * @param name
     *            名称.
     */
    public void setName(String name) {
        this.name = name;
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

    /** @return 排序. */
    @Column(name = "PRIORITY")
    public Integer getPriority() {
        return this.priority;
    }

    /**
     * @param priority
     *            排序.
     */
    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    /** @return 描述. */
    @Column(name = "DESCN", length = 200)
    public String getDescn() {
        return this.descn;
    }

    /**
     * @param descn
     *            描述.
     */
    public void setDescn(String descn) {
        this.descn = descn;
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
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "dictSchema")
    public Set<DictData> getDictDatas() {
        return this.dictDatas;
    }

    /**
     * @param dictDatas
     *            .
     */
    public void setDictDatas(Set<DictData> dictDatas) {
        this.dictDatas = dictDatas;
    }
}
