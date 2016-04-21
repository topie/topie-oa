package com.topie.security.impl;

import com.topie.security.api.UserAuth;
import com.topie.security.api.UserRealm;

public class UserRealmWrapper implements UserRealm {
    public UserAuth login(String username, String password, String tenantId) {
        return null;
    }

    public UserAuth findByRef(String ref, String tenantId) {
        return null;
    }

    public UserAuth findById(String id, String tenantId) {
        return null;
    }
}
