package com.topie.pim.persistence.manager;

import com.topie.core.hibernate.HibernateEntityDao;

import com.topie.pim.persistence.domain.PimInfo;

import org.springframework.stereotype.Service;

@Service
public class PimInfoManager extends HibernateEntityDao<PimInfo> {
}
