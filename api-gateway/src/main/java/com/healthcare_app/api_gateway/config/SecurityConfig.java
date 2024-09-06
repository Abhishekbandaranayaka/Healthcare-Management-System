package com.healthcare_app.api_gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final UserAuthenticationEntryPoint userAuthenticationEntryPoint;
    private final UserAuthProvider userAuthProvider;

    public SecurityConfig(UserAuthenticationEntryPoint userAuthenticationEntryPoint, UserAuthProvider userAuthProvider) {
        this.userAuthenticationEntryPoint = userAuthenticationEntryPoint;
        this.userAuthProvider = userAuthProvider;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .exceptionHandling().authenticationEntryPoint(userAuthenticationEntryPoint)
                .and()
                .addFilterBefore(new JwtAuthFilter(userAuthProvider), BasicAuthenticationFilter.class)
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers(HttpMethod.POST, "/login", "/register").permitAll()
                        .requestMatchers(HttpMethod.POST, "/admin/doctor/register").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/api/patients/**").hasAnyRole("PATIENT", "DOCTOR", "OPERATOR", "ADMIN")
                        .requestMatchers(HttpMethod.POST, "/api/patients/**").hasAnyRole("DOCTOR", "OPERATOR", "ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/api/patients/**").hasAnyRole("DOCTOR", "OPERATOR", "ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/api/patients/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/api/doctor/**").hasAnyRole("DOCTOR", "OPERATOR", "ADMIN")
                        .requestMatchers(HttpMethod.POST, "/api/doctor/**").hasAnyRole("OPERATOR", "ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/api/doctor/**").hasAnyRole("OPERATOR", "ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/api/doctor/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/api/appointments/**").hasAnyRole("PATIENT", "DOCTOR", "OPERATOR", "ADMIN")
                        .requestMatchers(HttpMethod.POST, "/api/appointments/**").hasAnyRole("DOCTOR", "OPERATOR", "ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/api/appointments/**").hasAnyRole("DOCTOR", "OPERATOR", "ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/api/appointments/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/api/medical_records/**").hasAnyRole("DOCTOR", "OPERATOR", "ADMIN")
                        .requestMatchers(HttpMethod.POST, "/api/medical_records/**").hasAnyRole("DOCTOR", "OPERATOR", "ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/api/medical_records/**").hasAnyRole("DOCTOR", "OPERATOR", "ADMIN")
                        .requestMatchers(HttpMethod.GET, "/api/billing/**").hasAnyRole("OPERATOR", "ADMIN")
                        .requestMatchers(HttpMethod.POST, "/api/billing/**").hasAnyRole("OPERATOR", "ADMIN")
                        .requestMatchers(HttpMethod.GET, "/api/notifications/**").hasAnyRole("OPERATOR", "ADMIN")
                        .requestMatchers(HttpMethod.POST, "/api/notifications/**").hasAnyRole("OPERATOR", "ADMIN")
                        .anyRequest().authenticated()
                );
        return http.build();
    }
}
