package com.topie.workcal.persistence.manager;

import com.topie.core.hibernate.HibernateEntityDao;

import com.topie.workcal.persistence.domain.WorkcalPart;

import org.springframework.stereotype.Service;

@Service
public class WorkcalPartManager extends HibernateEntityDao<WorkcalPart> {
}
