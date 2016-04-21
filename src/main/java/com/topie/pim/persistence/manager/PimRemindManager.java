package com.topie.pim.persistence.manager;

import com.topie.core.hibernate.HibernateEntityDao;

import com.topie.pim.persistence.domain.PimRemind;

import org.springframework.stereotype.Service;

@Service
public class PimRemindManager extends HibernateEntityDao<PimRemind> {
}
