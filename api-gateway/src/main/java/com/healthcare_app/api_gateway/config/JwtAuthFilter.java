package com.healthcare_app.api_gateway.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

/**
 * JWT Authentication Filter for validating and processing JWT tokens in incoming requests.
 * This filter extracts the JWT token from the Authorization header, validates it, and sets the authentication context.
 *
 * Author: B.T.M.A.S.D.B Rathnayaka
 * Date: 2024/07/29
 */
@RequiredArgsConstructor
public class JwtAuthFilter extends OncePerRequestFilter {

    private final UserAuthProvider userAuthProvider;

    /**
     * Processes each incoming request to extract and validate JWT tokens.
     * If a valid token is found, it sets the authentication context; otherwise, it clears the context.
     *
     * @param request The HTTP request to be processed.
     * @param response The HTTP response to be sent.
     * @param filterChain The filter chain to pass the request and response along.
     * @throws ServletException If an error occurs during request processing.
     * @throws IOException If an I/O error occurs during request processing.
     */
    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain) throws ServletException, IOException {

        // Retrieve the Authorization header from the request
        String header = request.getHeader(HttpHeaders.AUTHORIZATION);

        // Check if the Authorization header is present
        if (header != null) {
            // Split the header into its components (e.g., "Bearer <token>")
            String[] elements = header.split(" ");

            // Ensure the header starts with "Bearer" and contains a token
            if (elements.length == 2 && "Bearer".equalsIgnoreCase(elements[0])) {
                try {
                    // Validate the token and set the authentication in the SecurityContext
                    SecurityContextHolder.getContext().setAuthentication(
                            userAuthProvider.validateToken(elements[1])
                    );
                } catch (RuntimeException e) {
                    // Clear the security context if token validation fails
                    SecurityContextHolder.clearContext();
                    throw e;  // Rethrow the exception to propagate the error
                }
            }
        }
        // Continue with the next filter in the chain
        filterChain.doFilter(request, response);
    }
}
