package com.topie.security.util;

import javax.annotation.Resource;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.topie.api.userauth.UserAuthDTO;

import com.topie.core.auth.LogoutEvent;

import com.topie.spi.userauth.InternalUserAuthConnector;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.context.ApplicationContext;

import org.springframework.web.context.support.WebApplicationContextUtils;

public class LogoutHttpSessionListener implements HttpSessionListener {
    private static Logger logger = LoggerFactory
            .getLogger(LogoutHttpSessionListener.class);
    private InternalUserAuthConnector internalUserAuthConnector;

    public void sessionCreated(HttpSessionEvent se) {
    }

    public void sessionDestroyed(HttpSessionEvent se) {
        ApplicationContext ctx = WebApplicationContextUtils
                .getWebApplicationContext(se.getSession().getServletContext());

        if (ctx == null) {
            logger.warn("cannot find applicationContext");

            return;
        }

        HttpSession session = se.getSession();
        UserAuthDTO userAuthDto = this.internalUserAuthConnector
                .findFromSession(session);

        String tenantId = null;

        if (userAuthDto != null) {
            tenantId = userAuthDto.getTenantId();
        }

        LogoutEvent logoutEvent = new LogoutEvent(session, null,
                session.getId(), tenantId);
        ctx.publishEvent(logoutEvent);
    }

    @Resource
    public void setInternalUserAuthConnector(
            InternalUserAuthConnector internalUserAuthConnector) {
        this.internalUserAuthConnector = internalUserAuthConnector;
    }
}
