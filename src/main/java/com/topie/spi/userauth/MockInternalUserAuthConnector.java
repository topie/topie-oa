package com.topie.spi.userauth;

import javax.servlet.http.HttpSession;

import com.topie.api.userauth.UserAuthDTO;

public class MockInternalUserAuthConnector implements InternalUserAuthConnector {
    public UserAuthDTO findFromSession(HttpSession session) {
        return null;
    }
}
