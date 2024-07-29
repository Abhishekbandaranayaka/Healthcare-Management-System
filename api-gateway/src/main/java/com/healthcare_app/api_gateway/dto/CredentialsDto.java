package com.healthcare_app.api_gateway.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Data Transfer Object (DTO) for user credentials.
 * Used to transfer login and password information for authentication purposes.
 *
 * Author: B.T.M.A.S.D.B Rathnayaka
 * Date: 2024/07/29
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CredentialsDto {

    /**
     * The login identifier for the user.
     * Typically a username or email address used for authentication.
     */
    private String login;

    /**
     * The password associated with the user's login identifier.
     * Used in conjunction with the login to authenticate the user.
     */
    private String password;
}
