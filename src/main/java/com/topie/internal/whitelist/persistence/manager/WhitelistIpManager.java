package com.topie.internal.whitelist.persistence.manager;

import com.topie.core.hibernate.HibernateEntityDao;

import com.topie.internal.whitelist.persistence.domain.WhitelistIp;

import org.springframework.stereotype.Service;

@Service
public class WhitelistIpManager extends HibernateEntityDao<WhitelistIp> {
}
