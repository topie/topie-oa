package com.topie.org.persistence.manager;

import com.topie.core.hibernate.HibernateEntityDao;

import com.topie.org.persistence.domain.JobTitle;

import org.springframework.stereotype.Service;

@Service
public class JobTitleManager extends HibernateEntityDao<JobTitle> {
}
