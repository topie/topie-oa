package com.topie.ticket.persistence.manager;

import com.topie.core.hibernate.HibernateEntityDao;

import com.topie.ticket.persistence.domain.TicketInfo;

import org.springframework.stereotype.Service;

@Service
public class TicketInfoManager extends HibernateEntityDao<TicketInfo> {
}
