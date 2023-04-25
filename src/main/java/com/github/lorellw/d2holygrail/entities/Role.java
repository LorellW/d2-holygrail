package com.github.lorellw.d2holygrail.entities;

import jakarta.persistence.Entity;
import org.springframework.security.core.GrantedAuthority;


public enum Role implements GrantedAuthority {
    ROLE_USER, ROLE_ADMIN;

    @Override
    public String getAuthority() {
        return name();
    }
}
