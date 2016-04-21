package com.topie.vote.persistence.manager;

import com.topie.core.hibernate.HibernateEntityDao;

import com.topie.vote.persistence.domain.VoteInfo;

import org.springframework.stereotype.Service;

@Service
public class VoteInfoManager extends HibernateEntityDao<VoteInfo> {
}
