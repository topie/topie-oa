package com.topie.bpm.persistence.manager;

import com.topie.bpm.persistence.domain.BpmCategory;

import com.topie.core.hibernate.HibernateEntityDao;

import org.springframework.stereotype.Service;

@Service
public class BpmCategoryManager extends HibernateEntityDao<BpmCategory> {
}
