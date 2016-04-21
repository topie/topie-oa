package com.topie.customer.persistence.manager;

import com.topie.core.hibernate.HibernateEntityDao;

import com.topie.customer.persistence.domain.CustomerInfo;

import org.springframework.stereotype.Service;

@Service
public class CustomerInfoManager extends HibernateEntityDao<CustomerInfo> {
}
