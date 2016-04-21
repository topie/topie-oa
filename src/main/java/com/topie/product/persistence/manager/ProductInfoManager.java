package com.topie.product.persistence.manager;

import com.topie.core.hibernate.HibernateEntityDao;

import com.topie.product.persistence.domain.ProductInfo;

import org.springframework.stereotype.Service;

@Service
public class ProductInfoManager extends HibernateEntityDao<ProductInfo> {
}
