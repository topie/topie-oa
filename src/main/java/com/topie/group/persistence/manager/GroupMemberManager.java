package com.topie.group.persistence.manager;

import com.topie.core.hibernate.HibernateEntityDao;

import com.topie.group.persistence.domain.GroupMember;

import org.springframework.stereotype.Service;

@Service
public class GroupMemberManager extends HibernateEntityDao<GroupMember> {
}
