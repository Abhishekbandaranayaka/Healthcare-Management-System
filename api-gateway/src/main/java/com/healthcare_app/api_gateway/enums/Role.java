package com.healthcare_app.api_gateway.enums;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    ADMIN,
    OPERATOR,
    PATIENT,
    DOCTOR;

    @Override
    public String getAuthority() {
        return this.name();
    }
}
