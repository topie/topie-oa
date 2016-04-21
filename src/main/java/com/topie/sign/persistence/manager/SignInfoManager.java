package com.topie.sign.persistence.manager;

import com.topie.core.hibernate.HibernateEntityDao;

import com.topie.sign.persistence.domain.SignInfo;

import org.springframework.stereotype.Service;

@Service
public class SignInfoManager extends HibernateEntityDao<SignInfo> {
}
