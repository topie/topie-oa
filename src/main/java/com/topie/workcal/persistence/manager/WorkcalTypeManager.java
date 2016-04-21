package com.topie.workcal.persistence.manager;

import com.topie.core.hibernate.HibernateEntityDao;

import com.topie.workcal.persistence.domain.WorkcalType;

import org.springframework.stereotype.Service;

@Service
public class WorkcalTypeManager extends HibernateEntityDao<WorkcalType> {
}
