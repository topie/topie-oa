package com.topie.bpm.persistence.manager;

import com.topie.bpm.persistence.domain.BpmProcess;

import com.topie.core.hibernate.HibernateEntityDao;

import org.springframework.stereotype.Service;

@Service
public class BpmProcessManager extends HibernateEntityDao<BpmProcess> {
}
