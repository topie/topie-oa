package com.topie.pim.persistence.manager;

import com.topie.core.hibernate.HibernateEntityDao;

import com.topie.pim.persistence.domain.PimPhrase;

import org.springframework.stereotype.Service;

@Service
public class PimPhraseManager extends HibernateEntityDao<PimPhrase> {
}
