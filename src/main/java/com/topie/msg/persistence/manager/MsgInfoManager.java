package com.topie.msg.persistence.manager;

import com.topie.core.hibernate.HibernateEntityDao;

import com.topie.msg.persistence.domain.MsgInfo;

import org.springframework.stereotype.Service;

@Service
public class MsgInfoManager extends HibernateEntityDao<MsgInfo> {
}
