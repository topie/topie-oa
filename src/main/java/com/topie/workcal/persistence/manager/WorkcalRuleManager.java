package com.topie.workcal.persistence.manager;

import com.topie.core.hibernate.HibernateEntityDao;

import com.topie.workcal.persistence.domain.WorkcalRule;

import org.springframework.stereotype.Service;

@Service
public class WorkcalRuleManager extends HibernateEntityDao<WorkcalRule> {
}
