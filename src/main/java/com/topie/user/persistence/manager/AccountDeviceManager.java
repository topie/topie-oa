package com.topie.user.persistence.manager;

import com.topie.core.hibernate.HibernateEntityDao;

import com.topie.user.persistence.domain.AccountDevice;

import org.springframework.stereotype.Service;

@Service
public class AccountDeviceManager extends HibernateEntityDao<AccountDevice> {
}
