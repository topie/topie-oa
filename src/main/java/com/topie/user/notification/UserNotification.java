package com.topie.user.notification;

import com.topie.user.persistence.domain.UserBase;

public interface UserNotification {
    void insertUser(UserBase userBase);

    void updateUser(UserBase userBase);

    void removeUser(UserBase userBase);
}
