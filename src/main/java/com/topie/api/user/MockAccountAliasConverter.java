package com.topie.api.user;

public class MockAccountAliasConverter implements AccountAliasConverter {
    public String convertAlias(String alias) {
        return alias;
    }
}
