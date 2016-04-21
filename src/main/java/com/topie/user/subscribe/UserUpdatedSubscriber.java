package com.topie.user.subscribe;

import java.io.IOException;

import javax.annotation.Resource;

import com.topie.api.tenant.TenantConnector;
import com.topie.api.tenant.TenantDTO;
import com.topie.api.user.UserCache;
import com.topie.api.user.UserDTO;
import com.topie.api.userauth.UserAuthCache;
import com.topie.api.userauth.UserAuthConnector;
import com.topie.api.userauth.UserAuthDTO;

import com.topie.core.mapper.JsonMapper;
import com.topie.core.subscribe.Subscribable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Component;

@Component("com.topie.user.subscribe.UserUpdatedSubscriber")
public class UserUpdatedSubscriber implements Subscribable<String> {
    private static Logger logger = LoggerFactory
            .getLogger(UserUpdatedSubscriber.class);
    private JsonMapper jsonMapper = new JsonMapper();
    private String destinationName = "topic.user.notify.updated";
    private UserCache userCache;
    private UserAuthCache userAuthCache;
    private TenantConnector tenantConnector;
    private UserAuthConnector userAuthConnector;

    public void handleMessage(String message) {
        try {
            UserDTO userDto = jsonMapper.fromJson(message, UserDTO.class);

            userCache.updateUser(userDto);

            for (TenantDTO tenantDto : tenantConnector.findAll()) {
                UserAuthDTO userAuthDto = userAuthConnector.findByUsername(
                        userDto.getUsername(), tenantDto.getId());
                userAuthCache.updateUserAuth(userAuthDto);
            }

            logger.info("update user : {}", message);
        } catch (IOException ex) {
            logger.error(ex.getMessage(), ex);
        }
    }

    public boolean isTopic() {
        return true;
    }

    public String getName() {
        return destinationName;
    }

    public void setDestinationName(String destinationName) {
        this.destinationName = destinationName;
    }

    @Resource
    public void setUserCache(UserCache userCache) {
        this.userCache = userCache;
    }

    @Resource
    public void setUserAuthCache(UserAuthCache userAuthCache) {
        this.userAuthCache = userAuthCache;
    }

    @Resource
    public void setTenantConnector(TenantConnector tenantConnector) {
        this.tenantConnector = tenantConnector;
    }

    @Resource
    public void setUserAuthConnector(UserAuthConnector userAuthConnector) {
        this.userAuthConnector = userAuthConnector;
    }
}
