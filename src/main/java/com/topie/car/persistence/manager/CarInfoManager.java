package com.topie.car.persistence.manager;

import com.topie.car.persistence.domain.CarInfo;

import com.topie.core.hibernate.HibernateEntityDao;

import org.springframework.stereotype.Service;

@Service
public class CarInfoManager extends HibernateEntityDao<CarInfo> {
}
