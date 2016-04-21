package com.topie.ticket.persistence.domain;

// Generated by Hibernate Tools
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * TicketInfo .
 * 
 * @author Lingo
 */
@Entity
@Table(name = "TICKET_INFO")
public class TicketInfo implements java.io.Serializable {
    private static final long serialVersionUID = 0L;

    /** null. */
    private Long id;

    /** null. */
    private TicketGroup ticketGroup;

    /** null. */
    private TicketCatalog ticketCatalog;

    /** null. */
    private String code;

    /** null. */
    private String name;

    /** null. */
    private String content;

    /** null. */
    private String creator;

    /** null. */
    private String status;

    /** null. */
    private Date createTime;

    /** null. */
    private String assignee;

    /** null. */
    private Date updateTime;

    /** . */
    private Set<TicketComment> ticketComments = new HashSet<TicketComment>(0);

    public TicketInfo() {
    }

    public TicketInfo(Long id) {
        this.id = id;
    }

    public TicketInfo(Long id, TicketGroup ticketGroup,
            TicketCatalog ticketCatalog, String code, String name,
            String content, String creator, String status, Date createTime,
            String assignee, Date updateTime, Set<TicketComment> ticketComments) {
        this.id = id;
        this.ticketGroup = ticketGroup;
        this.ticketCatalog = ticketCatalog;
        this.code = code;
        this.name = name;
        this.content = content;
        this.creator = creator;
        this.status = status;
        this.createTime = createTime;
        this.assignee = assignee;
        this.updateTime = updateTime;
        this.ticketComments = ticketComments;
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
    @JoinColumn(name = "GROUP_ID")
    public TicketGroup getTicketGroup() {
        return this.ticketGroup;
    }

    /**
     * @param ticketGroup
     *            null.
     */
    public void setTicketGroup(TicketGroup ticketGroup) {
        this.ticketGroup = ticketGroup;
    }

    /** @return null. */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CATALOG_ID")
    public TicketCatalog getTicketCatalog() {
        return this.ticketCatalog;
    }

    /**
     * @param ticketCatalog
     *            null.
     */
    public void setTicketCatalog(TicketCatalog ticketCatalog) {
        this.ticketCatalog = ticketCatalog;
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
    @Column(name = "CONTENT", length = 65535)
    public String getContent() {
        return this.content;
    }

    /**
     * @param content
     *            null.
     */
    public void setContent(String content) {
        this.content = content;
    }

    /** @return null. */
    @Column(name = "CREATOR", length = 64)
    public String getCreator() {
        return this.creator;
    }

    /**
     * @param creator
     *            null.
     */
    public void setCreator(String creator) {
        this.creator = creator;
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
    @Column(name = "ASSIGNEE", length = 64)
    public String getAssignee() {
        return this.assignee;
    }

    /**
     * @param assignee
     *            null.
     */
    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    /** @return null. */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "UPDATE_TIME", length = 26)
    public Date getUpdateTime() {
        return this.updateTime;
    }

    /**
     * @param updateTime
     *            null.
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /** @return . */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "ticketInfo")
    public Set<TicketComment> getTicketComments() {
        return this.ticketComments;
    }

    /**
     * @param ticketComments
     *            .
     */
    public void setTicketComments(Set<TicketComment> ticketComments) {
        this.ticketComments = ticketComments;
    }
}
