package com.topie.auth.persistence.manager;

import com.topie.auth.persistence.domain.UserStatus;

import com.topie.core.hibernate.HibernateEntityDao;

import org.springframework.stereotype.Service;

@Service
public class UserStatusManager extends HibernateEntityDao<UserStatus> {
}
