package com.topie.auth.persistence.manager;

import com.topie.auth.persistence.domain.Perm;

import com.topie.core.hibernate.HibernateEntityDao;

import org.springframework.stereotype.Service;

@Service
public class PermManager extends HibernateEntityDao<Perm> {
}
