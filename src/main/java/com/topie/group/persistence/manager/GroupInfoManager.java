package com.topie.group.persistence.manager;

import com.topie.core.hibernate.HibernateEntityDao;

import com.topie.group.persistence.domain.GroupInfo;

import org.springframework.stereotype.Service;

@Service
public class GroupInfoManager extends HibernateEntityDao<GroupInfo> {
}
