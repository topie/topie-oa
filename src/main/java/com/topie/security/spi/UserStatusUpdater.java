package com.topie.security.spi;

public interface UserStatusUpdater {
    void updateUser(String username, int status);

    void removeUser(String username);
}
