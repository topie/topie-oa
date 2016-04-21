package com.topie.recruit.persistence.manager;

import com.topie.core.hibernate.HibernateEntityDao;

import com.topie.recruit.persistence.domain.RecruitInfo;

import org.springframework.stereotype.Service;

@Service
public class RecruitInfoManager extends HibernateEntityDao<RecruitInfo> {
}
