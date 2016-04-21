package com.topie.meeting.persistence.manager;

import com.topie.core.hibernate.HibernateEntityDao;

import com.topie.meeting.persistence.domain.MeetingAttendee;

import org.springframework.stereotype.Service;

@Service
public class MeetingAttendeeManager extends HibernateEntityDao<MeetingAttendee> {
}
