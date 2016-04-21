package com.topie.javamail.persistence.manager;

import com.topie.core.hibernate.HibernateEntityDao;

import com.topie.javamail.persistence.domain.JavamailConfig;

import org.springframework.stereotype.Service;

@Service
public class JavamailConfigManager extends HibernateEntityDao<JavamailConfig> {
}
