package com.topie.user.persistence.manager;

import com.topie.core.hibernate.HibernateEntityDao;

import com.topie.user.persistence.domain.UserSchema;

import org.springframework.stereotype.Service;

@Service
public class UserSchemaManager extends HibernateEntityDao<UserSchema> {
}
