package com.topie.humantask.persistence.manager;

import com.topie.core.hibernate.HibernateEntityDao;

import com.topie.humantask.persistence.domain.TaskInfo;

import org.springframework.stereotype.Service;

@Service
public class TaskInfoManager extends HibernateEntityDao<TaskInfo> {
}
