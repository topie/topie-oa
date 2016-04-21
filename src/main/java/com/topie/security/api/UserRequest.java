package com.topie.security.api;

public interface UserRequest {
    String getId();

    String getTenantId();

    String getUsername();

    String getPassword();
}
