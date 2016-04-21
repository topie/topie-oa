package com.topie.humantask.persistence.manager;

import com.topie.core.hibernate.HibernateEntityDao;

import com.topie.humantask.persistence.domain.TaskDefOperation;

import org.springframework.stereotype.Service;

@Service
public class TaskDefOperationManager extends
        HibernateEntityDao<TaskDefOperation> {
}
