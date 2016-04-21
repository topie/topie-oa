package com.topie.user.persistence.manager;

import com.topie.core.hibernate.HibernateEntityDao;

import com.topie.user.persistence.domain.AccountLockInfo;

import org.springframework.stereotype.Service;

@Service
public class AccountLockInfoManager extends HibernateEntityDao<AccountLockInfo> {
}
