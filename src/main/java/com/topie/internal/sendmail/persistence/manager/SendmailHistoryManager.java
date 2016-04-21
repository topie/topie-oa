package com.topie.internal.sendmail.persistence.manager;

import com.topie.core.hibernate.HibernateEntityDao;

import com.topie.internal.sendmail.persistence.domain.SendmailHistory;

import org.springframework.stereotype.Service;

@Service
public class SendmailHistoryManager extends HibernateEntityDao<SendmailHistory> {
}
