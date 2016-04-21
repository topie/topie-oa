package com.topie.auth.support;

import java.util.Collections;

import com.topie.api.tenant.TenantConnector;
import com.topie.api.user.UserConnector;
import com.topie.api.userauth.UserAuthConnector;
import com.topie.api.userauth.UserAuthDTO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.jdbc.core.JdbcTemplate;

public class MockUserAuthConnector implements UserAuthConnector {
    private static Logger logger = LoggerFactory
            .getLogger(MockUserAuthConnector.class);
    private JdbcTemplate jdbcTemplate;
    private TenantConnector tenantConnector;
    private UserConnector userConnector;
    private UserAuthDTO userAuthDto;

    public MockUserAuthConnector() {
        userAuthDto = new UserAuthDTO();
        userAuthDto.setId("1");
        userAuthDto.setTenantId("1");
        userAuthDto.setUsername("lingo");
        userAuthDto.setRef("1");
        userAuthDto.setDisplayName("lingo");
        userAuthDto.setStatus("1");

        userAuthDto.setPermissions(Collections.singletonList("*"));
        userAuthDto.setRoles(Collections.singletonList("ROLE_ADMIN"));
    }

    public UserAuthDTO findByUsername(String username, String tenantId) {
        return userAuthDto;
    }

    public UserAuthDTO findByRef(String ref, String tenantId) {
        return userAuthDto;
    }

    public UserAuthDTO findById(String id, String tenantId) {
        return userAuthDto;
    }
}
