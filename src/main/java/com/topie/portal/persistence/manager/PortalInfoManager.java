package com.topie.portal.persistence.manager;

import com.topie.core.hibernate.HibernateEntityDao;

import com.topie.portal.persistence.domain.PortalInfo;

import org.springframework.stereotype.Service;

@Service
public class PortalInfoManager extends HibernateEntityDao<PortalInfo> {
}
