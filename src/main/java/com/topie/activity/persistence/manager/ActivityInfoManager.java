package com.topie.activity.persistence.manager;

import com.topie.activity.persistence.domain.ActivityInfo;

import com.topie.core.hibernate.HibernateEntityDao;

import org.springframework.stereotype.Service;

@Service
public class ActivityInfoManager extends HibernateEntityDao<ActivityInfo> {
}
