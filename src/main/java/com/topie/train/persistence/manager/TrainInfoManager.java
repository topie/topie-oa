package com.topie.train.persistence.manager;

import com.topie.core.hibernate.HibernateEntityDao;

import com.topie.train.persistence.domain.TrainInfo;

import org.springframework.stereotype.Service;

@Service
public class TrainInfoManager extends HibernateEntityDao<TrainInfo> {
}
