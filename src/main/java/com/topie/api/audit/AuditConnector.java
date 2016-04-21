package com.topie.api.audit;

public interface AuditConnector {
    void log(AuditDTO auditDto);
}
