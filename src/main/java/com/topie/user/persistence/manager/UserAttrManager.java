package com.topie.user.persistence.manager;

import com.topie.core.hibernate.HibernateEntityDao;

import com.topie.user.persistence.domain.UserAttr;

import org.springframework.stereotype.Service;

@Service
public class UserAttrManager extends HibernateEntityDao<UserAttr> {
}
