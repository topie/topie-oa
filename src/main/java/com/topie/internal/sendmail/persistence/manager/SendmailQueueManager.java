package com.topie.internal.sendmail.persistence.manager;

import com.topie.core.hibernate.HibernateEntityDao;

import com.topie.internal.sendmail.persistence.domain.SendmailQueue;

import org.springframework.stereotype.Service;

@Service
public class SendmailQueueManager extends HibernateEntityDao<SendmailQueue> {
}
