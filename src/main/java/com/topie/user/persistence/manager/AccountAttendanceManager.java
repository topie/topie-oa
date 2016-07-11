package com.topie.user.persistence.manager;


import com.topie.core.hibernate.HibernateEntityDao;
import com.topie.user.persistence.domain.AccountAttendance;

import org.springframework.stereotype.Service;

@Service
public class AccountAttendanceManager extends HibernateEntityDao<AccountAttendance> {
}
