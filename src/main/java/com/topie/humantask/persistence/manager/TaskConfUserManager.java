package com.topie.humantask.persistence.manager;

import com.topie.core.hibernate.HibernateEntityDao;

import com.topie.humantask.persistence.domain.TaskConfUser;

import org.springframework.stereotype.Service;

@Service
public class TaskConfUserManager extends HibernateEntityDao<TaskConfUser> {
}
