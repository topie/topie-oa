package com.topie.internal.whitelist.persistence.manager;

import com.topie.core.hibernate.HibernateEntityDao;

import com.topie.internal.whitelist.persistence.domain.WhitelistApp;

import org.springframework.stereotype.Service;

@Service
public class WhitelistAppManager extends HibernateEntityDao<WhitelistApp> {
}
