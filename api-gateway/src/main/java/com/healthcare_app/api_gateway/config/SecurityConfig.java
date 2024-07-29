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
                // Configure exception handling with a custom authentication entry point
                .exceptionHandling().authenticationEntryPoint(userAuthenticationEntryPoint)
                .and()
                // Add the JWT authentication filter before the BasicAuthenticationFilter
                .addFilterBefore(new JwtAuthFilter(userAuthProvider), BasicAuthenticationFilter.class)
                .csrf().disable() // Disable CSRF protection as it's not needed for stateless APIs
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) // Ensure session management is stateless
                .and()
                // Configure authorization rules for HTTP requests
                .authorizeHttpRequests((requests) -> requests
                        // Permit all requests to /login and /register (for POST methods)
                        .requestMatchers(HttpMethod.POST, "/login", "/register").permitAll()
                        // Require authentication for all other requests
                        .anyRequest().authenticated()
                );
        return http.build(); // Build and return the configured SecurityFilterChain
    }
}
