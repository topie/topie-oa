package com.topie.humantask.persistence.manager;

import com.topie.core.hibernate.HibernateEntityDao;

import com.topie.humantask.persistence.domain.TaskDeadline;

import org.springframework.stereotype.Service;

@Service
public class TaskDeadlineManager extends HibernateEntityDao<TaskDeadline> {
}
