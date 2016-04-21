package com.topie.humantask.persistence.manager;

import com.topie.core.hibernate.HibernateEntityDao;

import com.topie.humantask.persistence.domain.HtHumantask;

import org.springframework.stereotype.Service;

@Service
public class HtHumantaskManager extends HibernateEntityDao<HtHumantask> {
}
