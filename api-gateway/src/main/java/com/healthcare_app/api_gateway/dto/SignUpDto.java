package com.healthcare_app.api_gateway.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Data Transfer Object (DTO) for user sign-up details.
 * Used to transfer user information during the registration process.
 *
 * Author: B.T.M.A.S.D.B Rathnayaka
 * Date: 2024/07/29
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class SignUpDto {

    /**
     * The first name of the user.
     * Typically used to personalize user accounts.
     */
    private String firstName;

    /**
     * The last name of the user.
     * Typically used to personalize user accounts.
     */
    private String lastName;

    /**
     * The login identifier for the user.
     * Typically a username or email address used for registration.
     */
    private String login;

    /**
     * The password associated with the user's login identifier.
     * Used to secure the user account during registration.
     */
    private String password;
}
