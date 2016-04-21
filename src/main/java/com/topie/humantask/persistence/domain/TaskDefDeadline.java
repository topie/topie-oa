package com.topie.humantask.persistence.domain;

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
 * TaskDefDeadline 任务定义截止时间.
 * 
 * @author Lingo
 */
@Entity
@Table(name = "TASK_DEF_DEADLINE")
public class TaskDefDeadline implements java.io.Serializable {
    private static final long serialVersionUID = 0L;

    /** 主键. */
    private Long id;

    /** 外键，任务定义. */
    private TaskDefBase taskDefBase;

    /** 分类. */
    private String type;

    /** 持续时间. */
    private String duration;

    /** 状态. */
    private String status;

    /** 升级类型. */
    private String escalationType;

    /** 提醒条件. */
    private String notificationCondition;

    /** 提醒类型. */
    private String notificationType;

    /** 提醒接收人. */
    private String notificationReceiver;

    /** 提醒模板编号. */
    private String notificationTemplateCode;

    /** 重分配. */
    private String reassginment;

    /** 操作. */
    private String operation;

    /** . */
    private Set<TaskDefEscalation> taskDefEscalations = new HashSet<TaskDefEscalation>(
            0);

    public TaskDefDeadline() {
    }

    public TaskDefDeadline(Long id) {
        this.id = id;
    }

    public TaskDefDeadline(Long id, TaskDefBase taskDefBase, String type,
            String duration, String status, String escalationType,
            String notificationCondition, String notificationType,
            String notificationReceiver, String notificationTemplateCode,
            String reassginment, String operation,
            Set<TaskDefEscalation> taskDefEscalations) {
        this.id = id;
        this.taskDefBase = taskDefBase;
        this.type = type;
        this.duration = duration;
        this.status = status;
        this.escalationType = escalationType;
        this.notificationCondition = notificationCondition;
        this.notificationType = notificationType;
        this.notificationReceiver = notificationReceiver;
        this.notificationTemplateCode = notificationTemplateCode;
        this.reassginment = reassginment;
        this.operation = operation;
        this.taskDefEscalations = taskDefEscalations;
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

    /** @return 外键，任务定义. */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BASE_ID")
    public TaskDefBase getTaskDefBase() {
        return this.taskDefBase;
    }

    /**
     * @param taskDefBase
     *            外键，任务定义.
     */
    public void setTaskDefBase(TaskDefBase taskDefBase) {
        this.taskDefBase = taskDefBase;
    }

    /** @return 分类. */
    @Column(name = "TYPE", length = 50)
    public String getType() {
        return this.type;
    }

    /**
     * @param type
     *            分类.
     */
    public void setType(String type) {
        this.type = type;
    }

    /** @return 持续时间. */
    @Column(name = "DURATION", length = 100)
    public String getDuration() {
        return this.duration;
    }

    /**
     * @param duration
     *            持续时间.
     */
    public void setDuration(String duration) {
        this.duration = duration;
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

    /** @return 升级类型. */
    @Column(name = "ESCALATION_TYPE", length = 50)
    public String getEscalationType() {
        return this.escalationType;
    }

    /**
     * @param escalationType
     *            升级类型.
     */
    public void setEscalationType(String escalationType) {
        this.escalationType = escalationType;
    }

    /** @return 提醒条件. */
    @Column(name = "NOTIFICATION_CONDITION", length = 200)
    public String getNotificationCondition() {
        return this.notificationCondition;
    }

    /**
     * @param notificationCondition
     *            提醒条件.
     */
    public void setNotificationCondition(String notificationCondition) {
        this.notificationCondition = notificationCondition;
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

    /** @return 提醒接收人. */
    @Column(name = "NOTIFICATION_RECEIVER", length = 200)
    public String getNotificationReceiver() {
        return this.notificationReceiver;
    }

    /**
     * @param notificationReceiver
     *            提醒接收人.
     */
    public void setNotificationReceiver(String notificationReceiver) {
        this.notificationReceiver = notificationReceiver;
    }

    /** @return 提醒模板编号. */
    @Column(name = "NOTIFICATION_TEMPLATE_CODE", length = 200)
    public String getNotificationTemplateCode() {
        return this.notificationTemplateCode;
    }

    /**
     * @param notificationTemplateCode
     *            提醒模板编号.
     */
    public void setNotificationTemplateCode(String notificationTemplateCode) {
        this.notificationTemplateCode = notificationTemplateCode;
    }

    /** @return 重分配. */
    @Column(name = "REASSGINMENT", length = 200)
    public String getReassginment() {
        return this.reassginment;
    }

    /**
     * @param reassginment
     *            重分配.
     */
    public void setReassginment(String reassginment) {
        this.reassginment = reassginment;
    }

    /** @return 操作. */
    @Column(name = "OPERATION", length = 200)
    public String getOperation() {
        return this.operation;
    }

    /**
     * @param operation
     *            操作.
     */
    public void setOperation(String operation) {
        this.operation = operation;
    }

    /** @return . */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "taskDefDeadline")
    public Set<TaskDefEscalation> getTaskDefEscalations() {
        return this.taskDefEscalations;
    }

    /**
     * @param taskDefEscalations
     *            .
     */
    public void setTaskDefEscalations(Set<TaskDefEscalation> taskDefEscalations) {
        this.taskDefEscalations = taskDefEscalations;
    }
}