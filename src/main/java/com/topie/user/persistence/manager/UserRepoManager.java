package com.topie.user.persistence.manager;

import com.topie.core.hibernate.HibernateEntityDao;

import com.topie.user.persistence.domain.UserRepo;

import org.springframework.stereotype.Service;

@Service
public class UserRepoManager extends HibernateEntityDao<UserRepo> {
}
