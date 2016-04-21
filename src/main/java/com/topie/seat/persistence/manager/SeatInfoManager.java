package com.topie.seat.persistence.manager;

import com.topie.core.hibernate.HibernateEntityDao;

import com.topie.seat.persistence.domain.SeatInfo;

import org.springframework.stereotype.Service;

@Service
public class SeatInfoManager extends HibernateEntityDao<SeatInfo> {
}
