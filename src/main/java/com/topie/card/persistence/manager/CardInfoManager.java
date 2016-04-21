package com.topie.card.persistence.manager;

import com.topie.card.persistence.domain.CardInfo;

import com.topie.core.hibernate.HibernateEntityDao;

import org.springframework.stereotype.Service;

@Service
public class CardInfoManager extends HibernateEntityDao<CardInfo> {
}
