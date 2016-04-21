package com.topie.dict.persistence.manager;

import com.topie.core.hibernate.HibernateEntityDao;

import com.topie.dict.persistence.domain.DictInfo;

import org.springframework.stereotype.Service;

@Service
public class DictInfoManager extends HibernateEntityDao<DictInfo> {
}
