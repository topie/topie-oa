package com.topie.dict.persistence.manager;

import com.topie.core.hibernate.HibernateEntityDao;

import com.topie.dict.persistence.domain.DictSchema;

import org.springframework.stereotype.Service;

@Service
public class DictSchemaManager extends HibernateEntityDao<DictSchema> {
}
