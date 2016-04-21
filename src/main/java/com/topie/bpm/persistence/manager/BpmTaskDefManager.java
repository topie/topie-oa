package com.topie.bpm.persistence.manager;

import com.topie.bpm.persistence.domain.BpmTaskDef;

import com.topie.core.hibernate.HibernateEntityDao;

import org.springframework.stereotype.Service;

@Service
public class BpmTaskDefManager extends HibernateEntityDao<BpmTaskDef> {
}
