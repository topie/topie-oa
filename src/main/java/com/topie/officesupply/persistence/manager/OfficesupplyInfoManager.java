package com.topie.officesupply.persistence.manager;

import com.topie.core.hibernate.HibernateEntityDao;

import com.topie.officesupply.persistence.domain.OfficesupplyInfo;

import org.springframework.stereotype.Service;

@Service
public class OfficesupplyInfoManager extends
        HibernateEntityDao<OfficesupplyInfo> {
}
