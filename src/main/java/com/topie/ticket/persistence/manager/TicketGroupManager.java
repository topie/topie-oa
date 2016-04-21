package com.topie.ticket.persistence.manager;

import com.topie.core.hibernate.HibernateEntityDao;

import com.topie.ticket.persistence.domain.TicketGroup;

import org.springframework.stereotype.Service;

@Service
public class TicketGroupManager extends HibernateEntityDao<TicketGroup> {
}
