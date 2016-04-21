package com.topie.audit.persistence.manager;

import com.topie.audit.persistence.domain.AuditBase;

import com.topie.core.hibernate.HibernateEntityDao;

import org.springframework.stereotype.Service;

@Service
public class AuditBaseManager extends HibernateEntityDao<AuditBase> {
}
