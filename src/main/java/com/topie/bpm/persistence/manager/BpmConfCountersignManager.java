package com.topie.bpm.persistence.manager;

import com.topie.bpm.persistence.domain.BpmConfCountersign;

import com.topie.core.hibernate.HibernateEntityDao;

import org.springframework.stereotype.Service;

@Service
public class BpmConfCountersignManager extends
        HibernateEntityDao<BpmConfCountersign> {
}
