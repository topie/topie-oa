package com.topie.vote.persistence.manager;

import com.topie.core.hibernate.HibernateEntityDao;

import com.topie.vote.persistence.domain.VoteItem;

import org.springframework.stereotype.Service;

@Service
public class VoteItemManager extends HibernateEntityDao<VoteItem> {
}
