package com.topie.group.persistence.manager;

import com.topie.core.hibernate.HibernateEntityDao;

import com.topie.group.persistence.domain.GroupAdmin;

import org.springframework.stereotype.Service;

@Service
public class GroupAdminManager extends HibernateEntityDao<GroupAdmin> {
}
