package com.topie.inventory.persistence.manager;

import com.topie.core.hibernate.HibernateEntityDao;

import com.topie.inventory.persistence.domain.InventoryInfo;

import org.springframework.stereotype.Service;

@Service
public class InventoryInfoManager extends HibernateEntityDao<InventoryInfo> {
}
