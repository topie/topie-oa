package com.topie.org.persistence.manager;

import com.topie.core.hibernate.HibernateEntityDao;

import com.topie.org.persistence.domain.JobLevel;

import org.springframework.stereotype.Service;

@Service
public class JobLevelManager extends HibernateEntityDao<JobLevel> {
}
