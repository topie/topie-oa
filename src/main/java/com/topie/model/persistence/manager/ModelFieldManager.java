package com.topie.model.persistence.manager;

import com.topie.core.hibernate.HibernateEntityDao;

import com.topie.model.persistence.domain.ModelField;

import org.springframework.stereotype.Service;

@Service
public class ModelFieldManager extends HibernateEntityDao<ModelField> {
}
