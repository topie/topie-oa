package com.topie.user.persistence.manager;

import com.topie.core.hibernate.HibernateEntityDao;

import com.topie.user.persistence.domain.AccountInfo;

import org.springframework.stereotype.Service;

@Service
public class AccountInfoManager extends HibernateEntityDao<AccountInfo> {
}
