package com.topie.api.sendsms;

public interface SendsmsConnector {
    void send(String to, String content, String tenantId);
}
