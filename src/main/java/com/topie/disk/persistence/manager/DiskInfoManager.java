package com.topie.disk.persistence.manager;

import com.topie.core.hibernate.HibernateEntityDao;

import com.topie.disk.persistence.domain.DiskInfo;

import org.springframework.stereotype.Service;

@Service
public class DiskInfoManager extends HibernateEntityDao<DiskInfo> {
}
