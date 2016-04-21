package com.topie.group.persistence.manager;

import com.topie.core.hibernate.HibernateEntityDao;

import com.topie.group.persistence.domain.GroupType;

import org.springframework.stereotype.Service;

@Service
public class GroupTypeManager extends HibernateEntityDao<GroupType> {
}
