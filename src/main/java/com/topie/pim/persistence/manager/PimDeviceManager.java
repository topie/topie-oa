package com.topie.pim.persistence.manager;

import com.topie.core.hibernate.HibernateEntityDao;

import com.topie.pim.persistence.domain.PimDevice;

import org.springframework.stereotype.Service;

@Service
public class PimDeviceManager extends HibernateEntityDao<PimDevice> {
}
