package com.topie.security.impl;

import java.util.Collections;

import com.topie.security.api.UserFetcher;
import com.topie.security.api.UserInfo;

public class MockUserFetcher implements UserFetcher {
    public UserInfo getUserInfo(String username) {
        return getUserInfo(username, null, null);
    }

    public UserInfo getUserInfo(String username, String appId) {
        return getUserInfo(username, appId, null);
    }

    public UserInfo getUserInfo(String username, String appId, String repoCode) {
        UserInfoImpl userInfo = new UserInfoImpl();

        userInfo.setUsername(username);
        userInfo.setDisplayName(username);
        userInfo.setPassword("password");
        userInfo.setAuthorities(Collections.singletonList("*"));
        userInfo.setAttributes(Collections.EMPTY_LIST);
        userInfo.putExtraItem("repoCode", repoCode);
        userInfo.putExtraItem("appId", appId);

        return userInfo;
    }
}
