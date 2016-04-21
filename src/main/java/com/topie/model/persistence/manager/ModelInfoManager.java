package com.topie.model.persistence.manager;

import com.topie.core.hibernate.HibernateEntityDao;

import com.topie.model.persistence.domain.ModelInfo;

import org.springframework.stereotype.Service;

@Service
public class ModelInfoManager extends HibernateEntityDao<ModelInfo> {
}
