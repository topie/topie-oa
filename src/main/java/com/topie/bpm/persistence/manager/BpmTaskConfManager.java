package com.topie.bpm.persistence.manager;

import com.topie.bpm.persistence.domain.BpmTaskConf;

import com.topie.core.hibernate.HibernateEntityDao;

import org.springframework.stereotype.Service;

@Service
public class BpmTaskConfManager extends HibernateEntityDao<BpmTaskConf> {
}
