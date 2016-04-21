package com.topie.bpm.persistence.manager;

import com.topie.bpm.persistence.domain.BpmConfOperation;

import com.topie.core.hibernate.HibernateEntityDao;

import org.springframework.stereotype.Service;

@Service
public class BpmConfOperationManager extends
        HibernateEntityDao<BpmConfOperation> {
}
