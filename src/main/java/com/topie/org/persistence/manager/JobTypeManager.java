package com.topie.org.persistence.manager;

import com.topie.core.hibernate.HibernateEntityDao;

import com.topie.org.persistence.domain.JobType;

import org.springframework.stereotype.Service;

@Service
public class JobTypeManager extends HibernateEntityDao<JobType> {
}
