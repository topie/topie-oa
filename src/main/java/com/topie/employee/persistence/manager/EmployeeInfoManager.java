package com.topie.employee.persistence.manager;

import com.topie.core.hibernate.HibernateEntityDao;

import com.topie.employee.persistence.domain.EmployeeInfo;

import org.springframework.stereotype.Service;

@Service
public class EmployeeInfoManager extends HibernateEntityDao<EmployeeInfo> {
}
