package com.topie.org.persistence.manager;

import com.topie.core.hibernate.HibernateEntityDao;

import com.topie.org.persistence.domain.JobGrade;

import org.springframework.stereotype.Service;

@Service
public class JobGradeManager extends HibernateEntityDao<JobGrade> {
}
