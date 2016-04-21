package com.topie.leave.persistence.manager;

import com.topie.core.hibernate.HibernateEntityDao;

import com.topie.leave.persistence.domain.LeaveInfo;

import org.springframework.stereotype.Service;

@Service
public class LeaveInfoManager extends HibernateEntityDao<LeaveInfo> {
}
