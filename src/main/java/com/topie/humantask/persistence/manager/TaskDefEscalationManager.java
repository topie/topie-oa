package com.topie.humantask.persistence.manager;

import com.topie.core.hibernate.HibernateEntityDao;

import com.topie.humantask.persistence.domain.TaskDefEscalation;

import org.springframework.stereotype.Service;

@Service
public class TaskDefEscalationManager extends
        HibernateEntityDao<TaskDefEscalation> {
}
