package com.topie.plm.persistence.manager;

import com.topie.core.hibernate.HibernateEntityDao;

import com.topie.plm.persistence.domain.PlmVersion;

import org.springframework.stereotype.Service;

@Service
public class PlmVersionManager extends HibernateEntityDao<PlmVersion> {
}
