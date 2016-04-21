package com.topie.humantask.persistence.manager;

import com.topie.core.hibernate.HibernateEntityDao;

import com.topie.humantask.persistence.domain.HtParticipant;

import org.springframework.stereotype.Service;

@Service
public class HtParticipantManager extends HibernateEntityDao<HtParticipant> {
}
