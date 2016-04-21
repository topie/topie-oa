package com.topie.bpm.persistence.manager;

import com.topie.bpm.persistence.domain.BpmConfUser;

import com.topie.core.hibernate.HibernateEntityDao;

import org.springframework.stereotype.Service;

@Service
public class BpmConfUserManager extends HibernateEntityDao<BpmConfUser> {
}
