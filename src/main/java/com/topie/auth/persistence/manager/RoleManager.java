package com.topie.auth.persistence.manager;

import com.topie.auth.persistence.domain.Role;

import com.topie.core.hibernate.HibernateEntityDao;

import org.springframework.stereotype.Service;

@Service
public class RoleManager extends HibernateEntityDao<Role> {
}
