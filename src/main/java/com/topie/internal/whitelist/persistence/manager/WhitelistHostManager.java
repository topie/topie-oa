package com.topie.internal.whitelist.persistence.manager;

import com.topie.core.hibernate.HibernateEntityDao;

import com.topie.internal.whitelist.persistence.domain.WhitelistHost;

import org.springframework.stereotype.Service;

@Service
public class WhitelistHostManager extends HibernateEntityDao<WhitelistHost> {
}
