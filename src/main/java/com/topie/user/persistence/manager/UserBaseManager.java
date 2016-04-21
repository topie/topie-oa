package com.topie.user.persistence.manager;

import com.topie.core.hibernate.HibernateEntityDao;

import com.topie.user.persistence.domain.UserBase;

import org.springframework.stereotype.Service;

@Service
public class UserBaseManager extends HibernateEntityDao<UserBase> {
}
