package com.topie.org.persistence.domain;

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
 * JobType .
 * 
 * @author Lingo
 */
@Entity
@Table(name = "JOB_TYPE")
public class JobType implements java.io.Serializable {
    private static final long serialVersionUID = 0L;

    /** null. */
    private Long id;

    /** null. */
    private JobType jobType;

    /** null. */
    private String name;

    /** null. */
    private String tenantId;

    /** . */
    private Set<JobInfo> jobInfos = new HashSet<JobInfo>(0);

    /** . */
    private Set<JobType> jobTypes = new HashSet<JobType>(0);

    public JobType() {
    }

    public JobType(Long id) {
        this.id = id;
    }

    public JobType(Long id, JobType jobType, String name, String tenantId,
            Set<JobInfo> jobInfos, Set<JobType> jobTypes) {
        this.id = id;
        this.jobType = jobType;
        this.name = name;
        this.tenantId = tenantId;
        this.jobInfos = jobInfos;
        this.jobTypes = jobTypes;
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
    @JoinColumn(name = "PARENT_ID")
    public JobType getJobType() {
        return this.jobType;
    }

    /**
     * @param jobType
     *            null.
     */
    public void setJobType(JobType jobType) {
        this.jobType = jobType;
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
    @Column(name = "TENANT_ID", length = 50)
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
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "jobType")
    public Set<JobInfo> getJobInfos() {
        return this.jobInfos;
    }

    /**
     * @param jobInfos
     *            .
     */
    public void setJobInfos(Set<JobInfo> jobInfos) {
        this.jobInfos = jobInfos;
    }

    /** @return . */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "jobType")
    public Set<JobType> getJobTypes() {
        return this.jobTypes;
    }

    /**
     * @param jobTypes
     *            .
     */
    public void setJobTypes(Set<JobType> jobTypes) {
        this.jobTypes = jobTypes;
    }
}
