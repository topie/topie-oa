package com.topie.portal.persistence.manager;

import com.topie.core.hibernate.HibernateEntityDao;

import com.topie.portal.persistence.domain.PortalItem;

import org.springframework.stereotype.Service;

@Service
public class PortalItemManager extends HibernateEntityDao<PortalItem> {
}
