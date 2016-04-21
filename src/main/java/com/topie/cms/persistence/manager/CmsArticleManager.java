package com.topie.cms.persistence.manager;

import com.topie.cms.persistence.domain.CmsArticle;

import com.topie.core.hibernate.HibernateEntityDao;

import org.springframework.stereotype.Service;

@Service
public class CmsArticleManager extends HibernateEntityDao<CmsArticle> {
}
