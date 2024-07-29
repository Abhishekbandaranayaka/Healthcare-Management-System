package com.healthcare_app.api_gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.Arrays;

/**
 * Configuration class for setting up Cross-Origin Resource Sharing (CORS) in the application.
 * This class defines the CORS filter to allow cross-origin requests from specified origins
 * and to configure the allowed HTTP methods, headers, and other CORS settings.
 *
 * Author: B.T.M.A.S.D.B Rathnayaka
 * Date: 2024/07/29
 */
@Configuration
@EnableWebMvc
public class WebConfig {

    /**
     * Defines and configures the CORS filter to handle cross-origin requests.
     * Sets up allowed origins, methods, headers, and other CORS settings.
     *
     * @return A CorsFilter bean configured with the specified CORS settings.
     */
    @Bean
    public CorsFilter corsFilter() {
        // Create a source for CORS configurations
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

        // Create a new CORS configuration object
        CorsConfiguration config = new CorsConfiguration();

        // Allow credentials (e.g., cookies) to be included in CORS requests
        config.setAllowCredentials(true);

        // Specify allowed origin for CORS requests
        config.addAllowedOrigin("http://localhost:3000");

        // Set allowed headers for CORS requests
        config.setAllowedHeaders(Arrays.asList(
                HttpHeaders.AUTHORIZATION,
                HttpHeaders.CONTENT_TYPE,
                HttpHeaders.ACCEPT
        ));

        // Set allowed HTTP methods for CORS requests
        config.setAllowedMethods(Arrays.asList(
                HttpMethod.GET.name(),
                HttpMethod.POST.name(),
                HttpMethod.PUT.name(),
                HttpMethod.DELETE.name()
        ));

        // Set the maximum age (in seconds) of the preflight response cache
        config.setMaxAge(3600L);

        // Register the CORS configuration with the URL pattern
        source.registerCorsConfiguration("/**", config);

        // Return the configured CORS filter
        return new CorsFilter(source);
    }
}
