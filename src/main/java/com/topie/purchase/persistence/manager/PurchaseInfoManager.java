package com.topie.purchase.persistence.manager;

import com.topie.core.hibernate.HibernateEntityDao;

import com.topie.purchase.persistence.domain.PurchaseInfo;

import org.springframework.stereotype.Service;

@Service
public class PurchaseInfoManager extends HibernateEntityDao<PurchaseInfo> {
}
