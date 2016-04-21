package com.topie.ticket.persistence.manager;

import com.topie.core.hibernate.HibernateEntityDao;

import com.topie.ticket.persistence.domain.TicketMember;

import org.springframework.stereotype.Service;

@Service
public class TicketMemberManager extends HibernateEntityDao<TicketMember> {
}
