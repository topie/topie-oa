package com.topie.dict.persistence.manager;

import com.topie.core.hibernate.HibernateEntityDao;

import com.topie.dict.persistence.domain.DictType;

import org.springframework.stereotype.Service;

@Service
public class DictTypeManager extends HibernateEntityDao<DictType> {
}
