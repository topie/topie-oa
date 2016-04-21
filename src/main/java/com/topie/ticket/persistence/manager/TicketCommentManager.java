package com.topie.ticket.persistence.manager;

import com.topie.core.hibernate.HibernateEntityDao;

import com.topie.ticket.persistence.domain.TicketComment;

import org.springframework.stereotype.Service;

@Service
public class TicketCommentManager extends HibernateEntityDao<TicketComment> {
}
