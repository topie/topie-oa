package com.topie.officesupply.persistence.manager;

import com.topie.core.hibernate.HibernateEntityDao;

import com.topie.officesupply.persistence.domain.OfficesupplyReceive;

import org.springframework.stereotype.Service;

@Service
public class OfficesupplyReceiveManager extends
        HibernateEntityDao<OfficesupplyReceive> {
}
