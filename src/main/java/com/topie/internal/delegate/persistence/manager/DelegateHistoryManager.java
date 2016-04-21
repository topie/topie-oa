package com.topie.internal.delegate.persistence.manager;

import com.topie.core.hibernate.HibernateEntityDao;

import com.topie.internal.delegate.persistence.domain.DelegateHistory;

import org.springframework.stereotype.Service;

@Service
public class DelegateHistoryManager extends HibernateEntityDao<DelegateHistory> {
}
