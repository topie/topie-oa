package com.topie.auth.component;

import javax.annotation.Resource;

import com.topie.api.userauth.UserAuthCache;
import com.topie.api.userauth.UserAuthConnector;
import com.topie.api.userauth.UserAuthDTO;

import com.topie.auth.persistence.domain.Perm;
import com.topie.auth.persistence.domain.Role;
import com.topie.auth.persistence.domain.RoleDef;
import com.topie.auth.persistence.domain.UserStatus;

import org.springframework.stereotype.Component;

@Component
public class AuthCache {
    private UserAuthCache userAuthCache;
    private UserAuthConnector userAuthConnector;

    public void evictUser(String userId) {
        UserAuthDTO userAuthDto = userAuthConnector.findById(userId, "1");
        userAuthCache.removeUserAuth(userAuthDto);
    }

    public void evictUserStatus(UserStatus userStatus) {
        UserAuthDTO userAuthDto = new UserAuthDTO();
        userAuthDto.setId(Long.toString(userStatus.getId()));
        userAuthDto.setUsername(userStatus.getUsername());
        userAuthDto.setRef(userStatus.getRef());
        userAuthDto.setTenantId(userStatus.getTenantId());
        userAuthCache.removeUserAuth(userAuthDto);
    }

    public void evictRole(Role role) {
        for (UserStatus userStatus : role.getUserStatuses()) {
            evictUserStatus(userStatus);
        }
    }

    public void evictPerm(Perm perm) {
        for (RoleDef roleDef : perm.getRoleDefs()) {
            for (Role role : roleDef.getRoles()) {
                evictRole(role);
            }
        }
    }

    @Resource
    public void setUserAuthCache(UserAuthCache userAuthCache) {
        this.userAuthCache = userAuthCache;
    }

    @Resource
    public void setUserAuthConnector(UserAuthConnector userAuthConnector) {
        this.userAuthConnector = userAuthConnector;
    }
}
