package com.topie.bpm.persistence.manager;

import com.topie.bpm.persistence.domain.BpmTaskDefNotice;

import com.topie.core.hibernate.HibernateEntityDao;

import org.springframework.stereotype.Service;

@Service
public class BpmTaskDefNoticeManager extends
        HibernateEntityDao<BpmTaskDefNotice> {
}
