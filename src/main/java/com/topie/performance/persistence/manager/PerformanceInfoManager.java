package com.topie.performance.persistence.manager;

import com.topie.core.hibernate.HibernateEntityDao;

import com.topie.performance.persistence.domain.PerformanceInfo;

import org.springframework.stereotype.Service;

@Service
public class PerformanceInfoManager extends HibernateEntityDao<PerformanceInfo> {
}
