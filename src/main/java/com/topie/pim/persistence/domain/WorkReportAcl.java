package com.topie.pim.persistence.domain;

// Generated by Hibernate Tools
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * WorkReportAcl .
 * 
 * @author Lingo
 */
@Entity
@Table(name = "WORK_REPORT_ACL")
public class WorkReportAcl implements java.io.Serializable {
    private static final long serialVersionUID = 0L;

    /** null. */
    private Long id;

    /** null. */
    private WorkReportInfo workReportInfo;

    /** null. */
    private String type;

    /** null. */
    private String ref;

    /** null. */
    private String tenantId;

    public WorkReportAcl() {
    }

    public WorkReportAcl(Long id) {
        this.id = id;
    }

    public WorkReportAcl(Long id, WorkReportInfo workReportInfo, String type,
            String ref, String tenantId) {
        this.id = id;
        this.workReportInfo = workReportInfo;
        this.type = type;
        this.ref = ref;
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
    @JoinColumn(name = "INFO_ID")
    public WorkReportInfo getWorkReportInfo() {
        return this.workReportInfo;
    }

    /**
     * @param workReportInfo
     *            null.
     */
    public void setWorkReportInfo(WorkReportInfo workReportInfo) {
        this.workReportInfo = workReportInfo;
    }

    /** @return null. */
    @Column(name = "TYPE", length = 200)
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
    @Column(name = "REF", length = 200)
    public String getRef() {
        return this.ref;
    }

    /**
     * @param ref
     *            null.
     */
    public void setRef(String ref) {
        this.ref = ref;
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
