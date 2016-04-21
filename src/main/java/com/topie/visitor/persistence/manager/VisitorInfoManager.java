package com.topie.visitor.persistence.manager;

import com.topie.core.hibernate.HibernateEntityDao;

import com.topie.visitor.persistence.domain.VisitorInfo;

import org.springframework.stereotype.Service;

@Service
public class VisitorInfoManager extends HibernateEntityDao<VisitorInfo> {
}
