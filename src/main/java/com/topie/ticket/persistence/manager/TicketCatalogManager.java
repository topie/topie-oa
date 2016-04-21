package com.topie.ticket.persistence.manager;

import com.topie.core.hibernate.HibernateEntityDao;

import com.topie.ticket.persistence.domain.TicketCatalog;

import org.springframework.stereotype.Service;

@Service
public class TicketCatalogManager extends HibernateEntityDao<TicketCatalog> {
}
