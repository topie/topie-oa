package com.topie.user.persistence.manager;

import com.topie.core.hibernate.HibernateEntityDao;

import com.topie.user.persistence.domain.AccountOnline;

import org.springframework.stereotype.Service;

@Service
public class AccountOnlineManager extends HibernateEntityDao<AccountOnline> {
}
