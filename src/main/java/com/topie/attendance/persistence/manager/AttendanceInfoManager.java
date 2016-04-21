package com.topie.attendance.persistence.manager;

import com.topie.attendance.persistence.domain.AttendanceInfo;

import com.topie.core.hibernate.HibernateEntityDao;

import org.springframework.stereotype.Service;

@Service
public class AttendanceInfoManager extends HibernateEntityDao<AttendanceInfo> {
}
