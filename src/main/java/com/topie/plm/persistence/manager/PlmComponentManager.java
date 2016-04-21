package com.topie.plm.persistence.manager;

import com.topie.core.hibernate.HibernateEntityDao;

import com.topie.plm.persistence.domain.PlmComponent;

import org.springframework.stereotype.Service;

@Service
public class PlmComponentManager extends HibernateEntityDao<PlmComponent> {
}
