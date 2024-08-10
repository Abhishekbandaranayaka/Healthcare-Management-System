package com.healthcare_app.api_gateway.config;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.healthcare_app.api_gateway.dto.UserDto;
import com.healthcare_app.api_gateway.service.UserService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Base64;
import java.util.Collections;
import java.util.Date;

/**
 * Component responsible for generating and validating JWT tokens.
 * It handles the creation of tokens with a specified expiration time
 * and validates tokens to create authentication objects.
 *
 * Author: B.T.M.A.S.D.B Rathnayaka
 * Date: 2024/07/29
 */
@RequiredArgsConstructor
@Component
public class UserAuthProvider {

    @Value("${security.jwt.token.secret-key:secret-value}")
    private String secretKey; // Secret key used for signing and verifying JWTs

    private final UserService userService; // Service to retrieve user information

    /**
     * Initializes the secret key by encoding it in Base64 format.
     * This method is called after the bean is constructed.
     */
    @PostConstruct
    protected void init() {
        secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
    }

    /**
     * Creates a JWT token for the specified login.
     * The token includes the issuer (login), issued at date, and expiration date.
     *
     * @param login The login identifier for the user.
     * @return A signed JWT token.
     */
    public String createToken(String login, UserDto user) {
        Date now = new Date();
        Date validity = new Date(now.getTime() + 3_600_000); // Token valid for 1 hour

        return JWT.create()
                .withIssuer(login) // Set the issuer as the login
                .withIssuedAt(now) // Set the issued date
                .withExpiresAt(validity) // Set the expiration date
                .withClaim("role", user.getRole().name()) // Set the user's role claim
                .sign(Algorithm.HMAC256(secretKey)); // Sign the token with the secret key
    }

    /**
     * Validates the provided JWT token and returns an Authentication object.
     * It verifies the token, retrieves the user based on the token's issuer,
     * and constructs an authentication object with user details.
     *
     * @param token The JWT token to validate.
     * @return An Authentication object containing user details.
     */
    public Authentication validateToken(String token) {
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(secretKey))
                .build(); // Create a JWT verifier

        DecodedJWT decoded = verifier.verify(token); // Verify the token

        UserDto user = userService.findByLogin(decoded.getIssuer()); // Retrieve user details

        // Create an Authentication object with user details and empty authorities
        return new UsernamePasswordAuthenticationToken(user, null, Arrays.asList(user.getRole()));
    }
}
