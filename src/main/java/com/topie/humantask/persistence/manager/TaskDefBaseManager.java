package com.topie.humantask.persistence.manager;

import com.topie.core.hibernate.HibernateEntityDao;

import com.topie.humantask.persistence.domain.TaskDefBase;

import org.springframework.stereotype.Service;

@Service
public class TaskDefBaseManager extends HibernateEntityDao<TaskDefBase> {
}
