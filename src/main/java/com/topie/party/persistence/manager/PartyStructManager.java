package com.topie.party.persistence.manager;

import com.topie.core.hibernate.HibernateEntityDao;

import com.topie.party.persistence.domain.PartyStruct;

import org.springframework.stereotype.Service;

@Service
public class PartyStructManager extends HibernateEntityDao<PartyStruct> {
}
