package com.topie.pim.persistence.manager;

import com.topie.core.hibernate.HibernateEntityDao;

import com.topie.pim.persistence.domain.PimSchedule;

import org.springframework.stereotype.Service;

@Service
public class PimScheduleManager extends HibernateEntityDao<PimSchedule> {
}
