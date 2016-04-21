package com.topie.expense.persistence.manager;

import com.topie.core.hibernate.HibernateEntityDao;

import com.topie.expense.persistence.domain.ExpenseInfo;

import org.springframework.stereotype.Service;

@Service
public class ExpenseInfoManager extends HibernateEntityDao<ExpenseInfo> {
}
