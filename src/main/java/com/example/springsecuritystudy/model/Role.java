package com.example.springsecuritystudy.model;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    USER("ROLE_USER", "유저 권한"),
    MANAGER("ROLE_MANAGER", "매니저 권한"),
    ADMIN("ROLE_ADMIN", "어드민 권한");

    public static class ROLES{
        public static final String USER = "ROLE_USER";
        public static final String MANAGER = "ROLE_MANAGER";
        public static final String ADMIN = "ROLE_ADMIN";
    }


    private String roleAuth;
    private String description;

    private Role(String roleAuth, String description) {
        this.roleAuth = roleAuth;
        this.description = description;
    }

    @Override
    public String getAuthority() {
        return roleAuth;
    }

    public String getDescription() {
        return description;
    }
}
