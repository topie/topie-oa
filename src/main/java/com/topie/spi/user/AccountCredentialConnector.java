package com.topie.spi.user;

public interface AccountCredentialConnector {
    String findPassword(String username, String tenantId);
}
