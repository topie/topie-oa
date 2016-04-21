package com.topie.humantask.persistence.manager;

import com.topie.core.hibernate.HibernateEntityDao;

import com.topie.humantask.persistence.domain.TaskDefNotification;

import org.springframework.stereotype.Service;

@Service
public class TaskDefNotificationManager extends
        HibernateEntityDao<TaskDefNotification> {
}
