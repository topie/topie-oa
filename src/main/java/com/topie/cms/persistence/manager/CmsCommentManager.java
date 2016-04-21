package com.topie.cms.persistence.manager;

import com.topie.cms.persistence.domain.CmsComment;

import com.topie.core.hibernate.HibernateEntityDao;

import org.springframework.stereotype.Service;

@Service
public class CmsCommentManager extends HibernateEntityDao<CmsComment> {
}
