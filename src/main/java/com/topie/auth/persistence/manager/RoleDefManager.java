package com.topie.auth.persistence.manager;

import com.topie.auth.persistence.domain.RoleDef;

import com.topie.core.hibernate.HibernateEntityDao;

import org.springframework.stereotype.Service;

@Service
public class RoleDefManager extends HibernateEntityDao<RoleDef> {
}
