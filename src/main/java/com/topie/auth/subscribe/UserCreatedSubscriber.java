package com.topie.auth.subscribe;

import java.io.IOException;

import javax.annotation.Resource;

import com.topie.api.user.UserDTO;

import com.topie.auth.component.AuthCache;

import com.topie.core.id.IdGenerator;
import com.topie.core.mapper.JsonMapper;
import com.topie.core.subscribe.Subscribable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.stereotype.Component;

import org.springframework.transaction.annotation.Transactional;

@Transactional
@Component("com.topie.auth.component.UserCreatedSubscriber")
public class UserCreatedSubscriber implements Subscribable<String> {
    private static Logger logger = LoggerFactory
            .getLogger(UserCreatedSubscriber.class);
    private String insertSql = "INSERT INTO AUTH_USER_STATUS(ID,USERNAME,REF,STATUS,PASSWORD,USER_REPO_REF,TENANT_ID) VALUES(?,?,?,1,'',?,?)";
    private JsonMapper jsonMapper = new JsonMapper();
    private String destinationName = "queue.user.sync.created";
    private JdbcTemplate jdbcTemplate;
    private AuthCache authCache;
    private IdGenerator idGenerator;

    public void handleMessage(String message) {
        try {
            UserDTO userDto = jsonMapper.fromJson(message, UserDTO.class);
            String tenantId = userDto.getUserRepoRef();

            jdbcTemplate.update(insertSql, idGenerator.generateId(),
                    userDto.getUsername(), userDto.getId(), tenantId, tenantId);

            logger.info("create user : {}", message);
            authCache.evictUser(userDto.getId());
        } catch (IOException ex) {
            logger.error(ex.getMessage(), ex);
        }
    }

    public boolean isTopic() {
        return false;
    }

    public String getName() {
        return destinationName;
    }

    public void setDestinationName(String destinationName) {
        this.destinationName = destinationName;
    }

    @Resource
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Resource
    public void setAuthCache(AuthCache authCache) {
        this.authCache = authCache;
    }

    @Resource
    public void setIdGenerator(IdGenerator idGenerator) {
        this.idGenerator = idGenerator;
    }
}
