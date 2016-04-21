package com.topie.auth.component;

import javax.annotation.Resource;

import com.topie.auth.persistence.domain.UserStatus;

import com.topie.core.hibernate.EntityEvent;

import org.springframework.context.ApplicationListener;

import org.springframework.stereotype.Component;

@Component
public class UserStatusEventListener implements
        ApplicationListener<EntityEvent> {
    private AuthCache authCache;

    public void onApplicationEvent(EntityEvent event) {
        if (!event.supportsEntityType(UserStatus.class)) {
            return;
        }

        UserStatus userStatus = event.getEntity();
        authCache.evictUserStatus(userStatus);
    }

    @Resource
    public void setAuthCache(AuthCache authCache) {
        this.authCache = authCache;
    }
}
