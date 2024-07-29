package com.healthcare_app.api_gateway.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.healthcare_app.api_gateway.dto.ErrorDto;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * Custom implementation of AuthenticationEntryPoint for handling unauthorized access attempts.
 * This class is used to return a JSON response with an error message when an unauthenticated request
 * is made to a secured endpoint.
 *
 * Author: B.T.M.A.S.D.B Rathnayaka
 * Date: 2024/07/29
 */
@Component
public class UserAuthenticationEntryPoint implements AuthenticationEntryPoint {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    /**
     * Handles unauthorized access attempts by returning a JSON error response.
     * Sets the HTTP status to 401 (Unauthorized) and includes an error message in the response body.
     *
     * @param request The HTTP request that resulted in an authentication exception.
     * @param response The HTTP response to send to the client.
     * @param authException The exception that was thrown when authentication failed.
     * @throws IOException If an I/O error occurs during response writing.
     * @throws ServletException If a servlet error occurs during request handling.
     */
    @Override
    public void commence(
            HttpServletRequest request,
            HttpServletResponse response,
            AuthenticationException authException) throws IOException, ServletException {

        // Set the HTTP status code to 401 Unauthorized
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

        // Set the content type to JSON
        response.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);

        // Write the error response to the output stream
        ErrorDto errorDto = new ErrorDto("Unauthorized path");
        OBJECT_MAPPER.writeValue(response.getOutputStream(), errorDto);
    }
}
