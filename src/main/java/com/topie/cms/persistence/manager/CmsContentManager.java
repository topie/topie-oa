package com.topie.cms.persistence.manager;

import com.topie.cms.persistence.domain.CmsContent;

import com.topie.core.hibernate.HibernateEntityDao;

import org.springframework.stereotype.Service;

@Service
public class CmsContentManager extends HibernateEntityDao<CmsContent> {
}
