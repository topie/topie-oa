package com.topie.party.persistence.manager;

import com.topie.core.hibernate.HibernateEntityDao;

import com.topie.party.persistence.domain.PartyType;

import org.springframework.stereotype.Service;

@Service
public class PartyTypeManager extends HibernateEntityDao<PartyType> {
}
