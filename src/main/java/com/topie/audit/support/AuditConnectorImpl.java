package com.topie.audit.support;

import javax.annotation.Resource;

import com.topie.api.audit.AuditConnector;
import com.topie.api.audit.AuditDTO;

import com.topie.audit.persistence.domain.AuditBase;
import com.topie.audit.service.AuditService;

import com.topie.core.mapper.BeanMapper;

public class AuditConnectorImpl implements AuditConnector {
    private AuditService auditService;
    private BeanMapper beanMapper = new BeanMapper();

    public void log(AuditDTO auditDto) {
        AuditBase auditBase = new AuditBase();
        beanMapper.copy(auditDto, auditBase);
        auditService.log(auditBase);
    }

    @Resource
    public void setAuditService(AuditService auditService) {
        this.auditService = auditService;
    }
}
