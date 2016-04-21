package com.topie.vote.persistence.manager;

import com.topie.core.hibernate.HibernateEntityDao;

import com.topie.vote.persistence.domain.VoteUser;

import org.springframework.stereotype.Service;

@Service
public class VoteUserManager extends HibernateEntityDao<VoteUser> {
}
