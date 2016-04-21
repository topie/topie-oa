package com.topie.stamp.persistence.manager;

import com.topie.core.hibernate.HibernateEntityDao;

import com.topie.stamp.persistence.domain.StampInfo;

import org.springframework.stereotype.Service;

@Service
public class StampInfoManager extends HibernateEntityDao<StampInfo> {
}
