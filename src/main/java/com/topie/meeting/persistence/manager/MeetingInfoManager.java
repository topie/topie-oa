package com.topie.meeting.persistence.manager;

import com.topie.core.hibernate.HibernateEntityDao;

import com.topie.meeting.persistence.domain.MeetingInfo;

import org.springframework.stereotype.Service;

@Service
public class MeetingInfoManager extends HibernateEntityDao<MeetingInfo> {
}
