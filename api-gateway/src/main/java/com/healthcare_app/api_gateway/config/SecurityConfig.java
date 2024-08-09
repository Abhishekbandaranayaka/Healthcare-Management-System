package com.healthcare_app.api_gateway.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

/**
 * Security configuration class for setting up web security in the application.
 * This class configures security filters, exception handling, and authorization rules.
 *
 * Author: B.T.M.A.S.D.B Rathnayaka
 * Date: 2024/07/29
 */
@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final UserAuthenticationEntryPoint userAuthenticationEntryPoint;
    private final UserAuthProvider userAuthProvider;

    /**
     * Configures the security filter chain for HTTP requests.
     * Sets up custom authentication entry point, JWT filter, disables CSRF, and configures session management and request authorization.
     *
     * @param http The HttpSecurity object used to configure security settings.
     * @return The configured SecurityFilterChain.
     * @throws Exception If an error occurs during configuration.
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // Configure custom authentication entry point for handling unauthorized access
                .exceptionHandling().authenticationEntryPoint(userAuthenticationEntryPoint)
                .and()
                // Add the JWT authentication filter before the BasicAuthenticationFilter
                .addFilterBefore(new JwtAuthFilter(userAuthProvider), BasicAuthenticationFilter.class)
                // Disable CSRF protection as this is a stateless REST API using JWTs
                .csrf().disable()
                // Ensure session management is stateless
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                // Configure authorization rules for HTTP requests
                .authorizeHttpRequests((requests) -> requests
                        // Allow unauthenticated access to login and registration endpoints
                        .requestMatchers(HttpMethod.POST, "/login", "/register").permitAll()
                        // Define authorization rules for /api/patients endpoints
                        .requestMatchers(HttpMethod.GET, "/api/patients/**").hasAnyRole("PATIENT", "DOCTOR", "OPERATOR", "ADMIN")
                        .requestMatchers(HttpMethod.POST, "/api/patients/**").hasAnyRole("DOCTOR", "OPERATOR", "ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/api/patients/**").hasAnyRole("DOCTOR", "OPERATOR", "ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/api/patients/**").hasRole("ADMIN")
                        // Define authorization rules for /api/doctor endpoints
                        .requestMatchers(HttpMethod.GET, "/api/doctor/**").hasAnyRole("DOCTOR", "OPERATOR", "ADMIN")
                        .requestMatchers(HttpMethod.POST, "/api/doctor/**").hasAnyRole("OPERATOR", "ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/api/doctor/**").hasAnyRole("OPERATOR", "ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/api/doctor/**").hasRole("ADMIN")
                        // Define authorization rules for /api/appointments endpoints
                        .requestMatchers(HttpMethod.GET, "/api/appointments/**").hasAnyRole("PATIENT", "DOCTOR", "OPERATOR", "ADMIN")
                        .requestMatchers(HttpMethod.POST, "/api/appointments/**").hasAnyRole("DOCTOR", "OPERATOR", "ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/api/appointments/**").hasAnyRole("DOCTOR", "OPERATOR", "ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/api/appointments/**").hasRole("ADMIN")
                        // Define authorization rules for /api/medical_records endpoints
                        .requestMatchers(HttpMethod.GET, "/api/medical_records/**").hasAnyRole("DOCTOR", "OPERATOR", "ADMIN")
                        .requestMatchers(HttpMethod.POST, "/api/medical_records/**").hasAnyRole("DOCTOR", "OPERATOR", "ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/api/medical_records/**").hasAnyRole("DOCTOR", "OPERATOR", "ADMIN")
                        // Define authorization rules for /api/billing endpoints
                        .requestMatchers(HttpMethod.GET, "/api/billing/**").hasAnyRole("OPERATOR", "ADMIN")
                        .requestMatchers(HttpMethod.POST, "/api/billing/**").hasAnyRole("OPERATOR", "ADMIN")
                        // Define authorization rules for /api/notifications endpoints
                        .requestMatchers(HttpMethod.GET, "/api/notifications/**").hasAnyRole("OPERATOR", "ADMIN")
                        .requestMatchers(HttpMethod.POST, "/api/notifications/**").hasAnyRole("OPERATOR", "ADMIN")
                        // Require authentication for any other request
                        .anyRequest().authenticated()
                );
        // Build and return the configured SecurityFilterChain
        return http.build();
    }
}
