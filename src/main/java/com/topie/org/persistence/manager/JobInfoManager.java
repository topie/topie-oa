package com.topie.org.persistence.manager;

import com.topie.core.hibernate.HibernateEntityDao;

import com.topie.org.persistence.domain.JobInfo;

import org.springframework.stereotype.Service;

@Service
public class JobInfoManager extends HibernateEntityDao<JobInfo> {
}
