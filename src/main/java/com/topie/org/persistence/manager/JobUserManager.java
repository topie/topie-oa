package com.topie.org.persistence.manager;

import com.topie.core.hibernate.HibernateEntityDao;

import com.topie.org.persistence.domain.JobUser;

import org.springframework.stereotype.Service;

@Service
public class JobUserManager extends HibernateEntityDao<JobUser> {
}
