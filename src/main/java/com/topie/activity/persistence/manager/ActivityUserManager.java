package com.topie.activity.persistence.manager;

import com.topie.activity.persistence.domain.ActivityUser;

import com.topie.core.hibernate.HibernateEntityDao;

import org.springframework.stereotype.Service;

@Service
public class ActivityUserManager extends HibernateEntityDao<ActivityUser> {
}
