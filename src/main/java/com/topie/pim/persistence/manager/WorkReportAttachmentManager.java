package com.topie.pim.persistence.manager;

import com.topie.core.hibernate.HibernateEntityDao;

import com.topie.pim.persistence.domain.WorkReportAttachment;

import org.springframework.stereotype.Service;

@Service
public class WorkReportAttachmentManager extends
        HibernateEntityDao<WorkReportAttachment> {
}
