package com.topie.budget.persistence.manager;

import com.topie.budget.persistence.domain.BudgetInfo;

import com.topie.core.hibernate.HibernateEntityDao;

import org.springframework.stereotype.Service;

@Service
public class BudgetInfoManager extends HibernateEntityDao<BudgetInfo> {
}
