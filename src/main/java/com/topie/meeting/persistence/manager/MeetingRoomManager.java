package com.topie.meeting.persistence.manager;

import com.topie.core.hibernate.HibernateEntityDao;

import com.topie.meeting.persistence.domain.MeetingRoom;

import org.springframework.stereotype.Service;

@Service
public class MeetingRoomManager extends HibernateEntityDao<MeetingRoom> {
}
