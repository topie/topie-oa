package com.topie.org.persistence.manager;

import com.topie.core.hibernate.HibernateEntityDao;

import com.topie.org.persistence.domain.OrgCompany;

import org.springframework.stereotype.Service;

@Service
public class OrgCompanyManager extends HibernateEntityDao<OrgCompany> {
}
