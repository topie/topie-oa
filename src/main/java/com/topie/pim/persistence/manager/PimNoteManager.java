package com.topie.pim.persistence.manager;

import com.topie.core.hibernate.HibernateEntityDao;

import com.topie.pim.persistence.domain.PimNote;

import org.springframework.stereotype.Service;

@Service
public class PimNoteManager extends HibernateEntityDao<PimNote> {
}
