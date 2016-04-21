package com.topie.plm.persistence.manager;

import com.topie.core.hibernate.HibernateEntityDao;

import com.topie.plm.persistence.domain.PlmIssue;

import org.springframework.stereotype.Service;

@Service
public class PlmIssueManager extends HibernateEntityDao<PlmIssue> {
}
