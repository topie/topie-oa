package com.topie.disk.persistence.manager;

import com.topie.core.hibernate.HibernateEntityDao;

import com.topie.disk.persistence.domain.DiskShare;

import org.springframework.stereotype.Service;

@Service
public class DiskShareManager extends HibernateEntityDao<DiskShare> {
}
