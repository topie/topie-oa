package com.topie.internal.template.persistence.manager;

import com.topie.core.hibernate.HibernateEntityDao;

import com.topie.internal.template.persistence.domain.TemplateInfo;

import org.springframework.stereotype.Service;

@Service
public class TemplateInfoManager extends HibernateEntityDao<TemplateInfo> {
}
