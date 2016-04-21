package com.topie.business.persistence.manager;

import com.topie.business.persistence.domain.BusinessInfo;

import com.topie.core.hibernate.HibernateEntityDao;

import org.springframework.stereotype.Service;

@Service
public class BusinessInfoManager extends HibernateEntityDao<BusinessInfo> {
}
