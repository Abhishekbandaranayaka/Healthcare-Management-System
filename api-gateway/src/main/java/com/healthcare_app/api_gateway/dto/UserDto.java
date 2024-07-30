package com.healthcare_app.api_gateway.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Data Transfer Object (DTO) for user details.
 * Used to transfer user information, including authentication tokens.
 *
 * Author: B.T.M.A.S.D.B Rathnayaka
 * Date: 2024/07/29
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class UserDto {

    /**
     * The unique identifier of the user.
     * Typically used to reference the user in the system.
     */
    private Long id;

    /**
     * The first name of the user.
     * Used for personalization and identification.
     */
    private String firstName;

    /**
     * The last name of the user.
     * Used for personalization and identification.
     */
    private String lastName;

    /**
     * The login identifier of the user.
     * Typically a username or email address used for authentication.
     */
    private String login;

    /**
     * The authentication token for the user.
     * Used to manage user sessions and authorize access to protected resources.
     */
    private String token;
}
