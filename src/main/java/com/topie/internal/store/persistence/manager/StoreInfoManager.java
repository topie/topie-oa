package com.topie.internal.store.persistence.manager;

import com.topie.core.hibernate.HibernateEntityDao;

import com.topie.internal.store.persistence.domain.StoreInfo;

import org.springframework.stereotype.Service;

@Service
public class StoreInfoManager extends HibernateEntityDao<StoreInfo> {
}
