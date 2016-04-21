package com.topie.user.persistence.manager;

import com.topie.core.hibernate.HibernateEntityDao;

import com.topie.user.persistence.domain.PersonInfo;

import org.springframework.stereotype.Service;

@Service
public class PersonInfoManager extends HibernateEntityDao<PersonInfo> {
}
