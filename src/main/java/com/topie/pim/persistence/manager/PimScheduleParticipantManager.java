package com.topie.pim.persistence.manager;

import com.topie.core.hibernate.HibernateEntityDao;

import com.topie.pim.persistence.domain.PimScheduleParticipant;

import org.springframework.stereotype.Service;

@Service
public class PimScheduleParticipantManager extends
        HibernateEntityDao<PimScheduleParticipant> {
}
