package com.topie.dict.persistence.manager;

import com.topie.core.hibernate.HibernateEntityDao;

import com.topie.dict.persistence.domain.DictData;

import org.springframework.stereotype.Service;

@Service
public class DictDataManager extends HibernateEntityDao<DictData> {
}
