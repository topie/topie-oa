package com.topie.spi.user;

public class MockAccountCredentialConnector implements
        AccountCredentialConnector {
    public String findPassword(String username, String tenantId) {
        return username;
    }
}
