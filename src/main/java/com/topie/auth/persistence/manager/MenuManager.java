package com.topie.auth.persistence.manager;

import com.topie.auth.persistence.domain.Menu;

import com.topie.core.hibernate.HibernateEntityDao;

import org.springframework.stereotype.Service;

@Service
public class MenuManager extends HibernateEntityDao<Menu> {
}
