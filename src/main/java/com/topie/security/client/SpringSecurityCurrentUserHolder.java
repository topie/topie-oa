package com.topie.security.client;

import com.topie.core.auth.CurrentUserHolder;

import com.topie.security.util.SpringSecurityUtils;

public class SpringSecurityCurrentUserHolder implements CurrentUserHolder {
    public String getUserId() {
        return SpringSecurityUtils.getCurrentUserId();
    }

    public String getUsername() {
        return SpringSecurityUtils.getCurrentUsername();
    }
}
