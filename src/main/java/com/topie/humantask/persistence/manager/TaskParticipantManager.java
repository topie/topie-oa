package com.topie.humantask.persistence.manager;

import com.topie.core.hibernate.HibernateEntityDao;

import com.topie.humantask.persistence.domain.TaskParticipant;

import org.springframework.stereotype.Service;

@Service
public class TaskParticipantManager extends HibernateEntityDao<TaskParticipant> {
}
