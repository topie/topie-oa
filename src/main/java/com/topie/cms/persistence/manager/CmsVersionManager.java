package com.topie.cms.persistence.manager;

import com.topie.cms.persistence.domain.CmsVersion;

import com.topie.core.hibernate.HibernateEntityDao;

import org.springframework.stereotype.Service;

@Service
public class CmsVersionManager extends HibernateEntityDao<CmsVersion> {
}
