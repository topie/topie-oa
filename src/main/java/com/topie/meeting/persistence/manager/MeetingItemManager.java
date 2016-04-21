package com.topie.meeting.persistence.manager;

import com.topie.core.hibernate.HibernateEntityDao;

import com.topie.meeting.persistence.domain.MeetingItem;

import org.springframework.stereotype.Service;

@Service
public class MeetingItemManager extends HibernateEntityDao<MeetingItem> {
}
