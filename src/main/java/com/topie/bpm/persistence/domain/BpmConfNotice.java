package com.topie.bpm.persistence.domain;

// Generated by Hibernate Tools
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * BpmConfNotice 配置提醒.
 * 
 * @author Lingo
 */
@Entity
@Table(name = "BPM_CONF_NOTICE")
public class BpmConfNotice implements java.io.Serializable {
    private static final long serialVersionUID = 0L;

    /** 主键. */
    private Long id;

    /** 外键，模板. */
    private BpmMailTemplate bpmMailTemplate;

    /** 外键，配置节点. */
    private BpmConfNode bpmConfNode;

    /** 分类. */
    private Integer type;

    /** 接收人. */
    private String receiver;

    /** 持续时间. */
    private String dueDate;

    /** 模板编码. */
    private String templateCode;

    /** 提醒类型. */
    private String notificationType;

    public BpmConfNotice() {
    }

    public BpmConfNotice(Long id) {
        this.id = id;
    }

    public BpmConfNotice(Long id, BpmMailTemplate bpmMailTemplate,
            BpmConfNode bpmConfNode, Integer type, String receiver,
            String dueDate, String templateCode, String notificationType) {
        this.id = id;
        this.bpmMailTemplate = bpmMailTemplate;
        this.bpmConfNode = bpmConfNode;
        this.type = type;
        this.receiver = receiver;
        this.dueDate = dueDate;
        this.templateCode = templateCode;
        this.notificationType = notificationType;
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

    /** @return 外键，模板. */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TEMPLATE_ID")
    public BpmMailTemplate getBpmMailTemplate() {
        return this.bpmMailTemplate;
    }

    /**
     * @param bpmMailTemplate
     *            外键，模板.
     */
    public void setBpmMailTemplate(BpmMailTemplate bpmMailTemplate) {
        this.bpmMailTemplate = bpmMailTemplate;
    }

    /** @return 外键，配置节点. */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "NODE_ID")
    public BpmConfNode getBpmConfNode() {
        return this.bpmConfNode;
    }

    /**
     * @param bpmConfNode
     *            外键，配置节点.
     */
    public void setBpmConfNode(BpmConfNode bpmConfNode) {
        this.bpmConfNode = bpmConfNode;
    }

    /** @return 分类. */
    @Column(name = "TYPE")
    public Integer getType() {
        return this.type;
    }

    /**
     * @param type
     *            分类.
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /** @return 接收人. */
    @Column(name = "RECEIVER", length = 200)
    public String getReceiver() {
        return this.receiver;
    }

    /**
     * @param receiver
     *            接收人.
     */
    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    /** @return 持续时间. */
    @Column(name = "DUE_DATE", length = 50)
    public String getDueDate() {
        return this.dueDate;
    }

    /**
     * @param dueDate
     *            持续时间.
     */
    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    /** @return 模板编码. */
    @Column(name = "TEMPLATE_CODE", length = 200)
    public String getTemplateCode() {
        return this.templateCode;
    }

    /**
     * @param templateCode
     *            模板编码.
     */
    public void setTemplateCode(String templateCode) {
        this.templateCode = templateCode;
    }

    /** @return 提醒类型. */
    @Column(name = "NOTIFICATION_TYPE", length = 200)
    public String getNotificationType() {
        return this.notificationType;
    }

    /**
     * @param notificationType
     *            提醒类型.
     */
    public void setNotificationType(String notificationType) {
        this.notificationType = notificationType;
    }
}
