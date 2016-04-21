package com.topie.humantask.persistence.manager;

import com.topie.core.hibernate.HibernateEntityDao;

import com.topie.humantask.persistence.domain.TaskLog;

import org.springframework.stereotype.Service;

@Service
public class TaskLogManager extends HibernateEntityDao<TaskLog> {
}
