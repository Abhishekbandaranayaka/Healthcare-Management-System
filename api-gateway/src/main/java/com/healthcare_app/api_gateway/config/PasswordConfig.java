package com.healthcare_app.api_gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * Configuration class for setting up password encoding in the security configuration.
 * This class defines a bean for password encoding using BCrypt, which is a widely used
 * and secure hashing algorithm for password storage.
 *
 * Author: B.T.M.A.S.D.B Rathnayaka
 * Date: 2024/07/29
 */
@Component
public class PasswordConfig {

    /**
     * Defines a bean for the PasswordEncoder to be used for encoding passwords.
     * BCryptPasswordEncoder is used here, which provides strong encryption and salting for passwords.
     *
     * @return A PasswordEncoder instance configured with BCryptPasswordEncoder.
     */
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
