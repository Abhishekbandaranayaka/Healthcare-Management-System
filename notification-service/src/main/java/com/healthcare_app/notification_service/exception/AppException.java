package com.healthcare_app.notification_service.exception;

import org.springframework.http.HttpStatus;

/**
 * Custom exception class for the Healthcare App's Notification Service.
 * This exception is used to handle application-specific errors and associate them
 * with an appropriate HTTP status code.
 * Author: S T Fernando
 * Date: 2024/09/02
 */

public class AppException extends RuntimeException {

    /**
     * HTTP status code associated with this exception.
     */
    private final HttpStatus code;

    /**
     * Constructor for AppException.
     *
     * @param message The detailed error message.
     * @param code The HTTP status code to be returned.
     */

    public AppException(String message, HttpStatus code) {
        super(message);
        this.code = code;

        /**
         * Retrieves the HTTP status code associated with this exception.
         *
         * @return The HTTP status code.
         */
}
    public HttpStatus getCode(){
        return code;
    }
}