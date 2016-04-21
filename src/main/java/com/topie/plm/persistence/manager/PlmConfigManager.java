package com.topie.plm.persistence.manager;

import com.topie.core.hibernate.HibernateEntityDao;

import com.topie.plm.persistence.domain.PlmConfig;

import org.springframework.stereotype.Service;

@Service
public class PlmConfigManager extends HibernateEntityDao<PlmConfig> {
}
