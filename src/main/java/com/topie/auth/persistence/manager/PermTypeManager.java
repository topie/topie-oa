package com.topie.auth.persistence.manager;

import com.topie.auth.persistence.domain.PermType;

import com.topie.core.hibernate.HibernateEntityDao;

import org.springframework.stereotype.Service;

@Service
public class PermTypeManager extends HibernateEntityDao<PermType> {
}
