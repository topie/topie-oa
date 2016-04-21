package com.topie.user.persistence.manager;

import com.topie.core.hibernate.HibernateEntityDao;

import com.topie.user.persistence.domain.AccountHistoryCredential;

import org.springframework.stereotype.Service;

@Service
public class AccountHistoryCredentialManager extends
        HibernateEntityDao<AccountHistoryCredential> {
}
