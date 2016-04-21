package com.topie.sale.persistence.manager;

import com.topie.core.hibernate.HibernateEntityDao;

import com.topie.sale.persistence.domain.SaleInfo;

import org.springframework.stereotype.Service;

@Service
public class SaleInfoManager extends HibernateEntityDao<SaleInfo> {
}
