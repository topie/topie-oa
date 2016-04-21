package com.topie.disk.persistence.manager;

import com.topie.core.hibernate.HibernateEntityDao;

import com.topie.disk.persistence.domain.DiskAcl;

import org.springframework.stereotype.Service;

@Service
public class DiskAclManager extends HibernateEntityDao<DiskAcl> {
}
