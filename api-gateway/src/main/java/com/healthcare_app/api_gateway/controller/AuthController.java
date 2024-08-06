package com.healthcare_app.api_gateway.controller;

import com.healthcare_app.api_gateway.config.UserAuthProvider;
import com.healthcare_app.api_gateway.dto.CredentialsDto;
import com.healthcare_app.api_gateway.dto.SignUpDto;
import com.healthcare_app.api_gateway.dto.UserDto;
import com.healthcare_app.api_gateway.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

/**
 * Controller for handling authentication and user registration.
 * Provides endpoints for user login and registration, and manages JWT token creation.
 *
 * Author: B.T.M.A.S.D.B Rathnayaka
 * Date: 2024/07/29
 */
@RequiredArgsConstructor
@RestController
public class AuthController {

    private final UserService userService; // Service for user-related operations
    private final UserAuthProvider userAuthProvider; // Provider for handling JWT tokens

    /**
     * Handles user login requests.
     * Validates user credentials and generates a JWT token if successful.
     *
     * @param credentialsDto The credentials provided by the user for login.
     * @return A ResponseEntity containing the UserDto with user details and JWT token.
     */
    @PostMapping("/login")
    public ResponseEntity<UserDto> login(@RequestBody CredentialsDto credentialsDto) {
        UserDto user = userService.login(credentialsDto);
        if (user != null) {
            user.setToken(userAuthProvider.createToken(user.getLogin(), user));
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }


    /**
     * Handles user registration requests.
     * Registers a new user and generates a JWT token for the registered user.
     *
     * @param signUpDto The user details provided for registration.
     * @return A ResponseEntity containing the UserDto with user details, JWT token,
     *         and the location of the created user resource.
     */
    @PostMapping("/register")
    public ResponseEntity<UserDto> register(@RequestBody SignUpDto signUpDto) {
        // Register the new user with the provided details
        UserDto user = userService.register(signUpDto);

        // Generate a JWT token for the newly registered user
        user.setToken(userAuthProvider.createToken(user.getLogin() ,user));

        // Return a response with the created user resource URI and user details
        return ResponseEntity.created(URI.create("/users/" + user.getId()))
                .body(user);
    }
}
