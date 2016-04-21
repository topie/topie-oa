package com.topie.socialsecurity.persistence.manager;

import com.topie.core.hibernate.HibernateEntityDao;

import com.topie.socialsecurity.persistence.domain.SocialsecurityInfo;

import org.springframework.stereotype.Service;

@Service
public class SocialsecurityInfoManager extends
        HibernateEntityDao<SocialsecurityInfo> {
}
