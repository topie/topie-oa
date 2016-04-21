package com.topie.internal.sendmail.persistence.manager;

import com.topie.core.hibernate.HibernateEntityDao;

import com.topie.internal.sendmail.persistence.domain.SendmailTemplate;

import org.springframework.stereotype.Service;

@Service
public class SendmailTemplateManager extends
        HibernateEntityDao<SendmailTemplate> {
}
