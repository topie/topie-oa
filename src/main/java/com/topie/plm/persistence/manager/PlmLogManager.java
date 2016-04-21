package com.topie.plm.persistence.manager;

import com.topie.core.hibernate.HibernateEntityDao;

import com.topie.plm.persistence.domain.PlmLog;

import org.springframework.stereotype.Service;

@Service
public class PlmLogManager extends HibernateEntityDao<PlmLog> {
}
