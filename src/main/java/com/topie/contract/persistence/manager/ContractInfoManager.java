package com.topie.contract.persistence.manager;

import com.topie.contract.persistence.domain.ContractInfo;

import com.topie.core.hibernate.HibernateEntityDao;

import org.springframework.stereotype.Service;

@Service
public class ContractInfoManager extends HibernateEntityDao<ContractInfo> {
}
