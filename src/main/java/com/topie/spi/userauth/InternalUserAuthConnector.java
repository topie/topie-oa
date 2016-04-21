package com.topie.spi.userauth;

import javax.servlet.http.HttpSession;

import com.topie.api.userauth.UserAuthDTO;

public interface InternalUserAuthConnector {
    UserAuthDTO findFromSession(HttpSession session);
}
