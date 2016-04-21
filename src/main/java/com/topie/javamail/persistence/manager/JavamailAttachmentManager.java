package com.topie.javamail.persistence.manager;

import com.topie.core.hibernate.HibernateEntityDao;

import com.topie.javamail.persistence.domain.JavamailAttachment;

import org.springframework.stereotype.Service;

@Service
public class JavamailAttachmentManager extends
        HibernateEntityDao<JavamailAttachment> {
}
