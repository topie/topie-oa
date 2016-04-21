package com.topie.internal.delegate.persistence.manager;

import com.topie.core.hibernate.HibernateEntityDao;

import com.topie.internal.delegate.persistence.domain.DelegateInfo;

import org.springframework.stereotype.Service;

@Service
public class DelegateInfoManager extends HibernateEntityDao<DelegateInfo> {
}
