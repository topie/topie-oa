package com.topie.auth.component;

import com.topie.auth.persistence.domain.UserStatus;
import com.topie.auth.support.CheckUserStatusException;

import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.context.support.MessageSourceAccessor;

import org.springframework.stereotype.Component;

@Component
public class UserStatusChecker implements MessageSourceAware {
    private MessageSourceAccessor messages;

    public void check(UserStatus userStatus) {
        if ((userStatus.getId() != null) && (userStatus.getId() == 1)) {
            throw new CheckUserStatusException(messages.getMessage(
                    "user.superuser.edit", "不允许修改超级管理员"));
        }
    }

    public void setMessageSource(MessageSource messageSource) {
        this.messages = new MessageSourceAccessor(messageSource);
    }
}
