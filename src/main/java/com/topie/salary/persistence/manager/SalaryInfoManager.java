package com.topie.salary.persistence.manager;

import com.topie.core.hibernate.HibernateEntityDao;

import com.topie.salary.persistence.domain.SalaryInfo;

import org.springframework.stereotype.Service;

@Service
public class SalaryInfoManager extends HibernateEntityDao<SalaryInfo> {
}
