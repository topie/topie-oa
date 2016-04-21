package com.topie.javamail.persistence.manager;

import com.topie.core.hibernate.HibernateEntityDao;

import com.topie.javamail.persistence.domain.JavamailMessage;

import org.springframework.stereotype.Service;

@Service
public class JavamailMessageManager extends HibernateEntityDao<JavamailMessage> {
}
