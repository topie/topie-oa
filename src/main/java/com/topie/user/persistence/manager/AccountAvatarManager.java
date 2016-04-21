package com.topie.user.persistence.manager;

import com.topie.core.hibernate.HibernateEntityDao;

import com.topie.user.persistence.domain.AccountAvatar;

import org.springframework.stereotype.Service;

@Service
public class AccountAvatarManager extends HibernateEntityDao<AccountAvatar> {
}
