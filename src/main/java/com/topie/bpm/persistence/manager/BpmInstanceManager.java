package com.topie.bpm.persistence.manager;

import com.topie.bpm.persistence.domain.BpmInstance;

import com.topie.core.hibernate.HibernateEntityDao;

import org.springframework.stereotype.Service;

@Service
public class BpmInstanceManager extends HibernateEntityDao<BpmInstance> {
}
