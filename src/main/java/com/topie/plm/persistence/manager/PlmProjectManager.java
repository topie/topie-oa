package com.topie.plm.persistence.manager;

import com.topie.core.hibernate.HibernateEntityDao;

import com.topie.plm.persistence.domain.PlmProject;

import org.springframework.stereotype.Service;

@Service
public class PlmProjectManager extends HibernateEntityDao<PlmProject> {
}
