package com.topie.bpm.persistence.manager;

import com.topie.bpm.persistence.domain.BpmMailTemplate;

import com.topie.core.hibernate.HibernateEntityDao;

import org.springframework.stereotype.Service;

@Service
public class BpmMailTemplateManager extends HibernateEntityDao<BpmMailTemplate> {
}
