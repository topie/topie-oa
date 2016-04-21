package com.topie.plm.persistence.manager;

import com.topie.core.hibernate.HibernateEntityDao;

import com.topie.plm.persistence.domain.PlmCategory;

import org.springframework.stereotype.Service;

@Service
public class PlmCategoryManager extends HibernateEntityDao<PlmCategory> {
}
