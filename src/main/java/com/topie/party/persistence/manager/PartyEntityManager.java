package com.topie.party.persistence.manager;

import com.topie.core.hibernate.HibernateEntityDao;

import com.topie.party.persistence.domain.PartyEntity;

import org.springframework.stereotype.Service;

@Service
public class PartyEntityManager extends HibernateEntityDao<PartyEntity> {
}
