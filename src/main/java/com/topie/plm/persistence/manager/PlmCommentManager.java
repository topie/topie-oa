package com.topie.plm.persistence.manager;

import com.topie.core.hibernate.HibernateEntityDao;

import com.topie.plm.persistence.domain.PlmComment;

import org.springframework.stereotype.Service;

@Service
public class PlmCommentManager extends HibernateEntityDao<PlmComment> {
}
