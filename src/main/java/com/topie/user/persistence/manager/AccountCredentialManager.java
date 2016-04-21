package com.topie.user.persistence.manager;

import com.topie.core.hibernate.HibernateEntityDao;

import com.topie.user.persistence.domain.AccountCredential;

import org.springframework.stereotype.Service;

@Service
public class AccountCredentialManager extends
        HibernateEntityDao<AccountCredential> {
}
