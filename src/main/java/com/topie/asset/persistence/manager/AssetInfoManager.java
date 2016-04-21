package com.topie.asset.persistence.manager;

import com.topie.asset.persistence.domain.AssetInfo;

import com.topie.core.hibernate.HibernateEntityDao;

import org.springframework.stereotype.Service;

@Service
public class AssetInfoManager extends HibernateEntityDao<AssetInfo> {
}
