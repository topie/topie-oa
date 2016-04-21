package com.topie.form.persistence.manager;

import com.topie.core.hibernate.HibernateEntityDao;

import com.topie.form.persistence.domain.FormTemplate;

import org.springframework.stereotype.Service;

@Service
public class FormTemplateManager extends HibernateEntityDao<FormTemplate> {
}
