package com.healthcare_app.api_gateway.exceptions;

import org.springframework.http.HttpStatus;

/**
 * Custom exception class for handling application-specific errors.
 * Extends RuntimeException to provide a way to include HTTP status codes with error messages.
 *
 * Author: B.T.M.A.S.D.B Rathnayaka
 * Date: 2024/07/29
 */
public class AppException extends RuntimeException {

    /**
     * The HTTP status code associated with this exception.
     * Used to convey the error type or status in HTTP responses.
     */
    private final HttpStatus code;

    /**
     * Constructor to create a new AppException with a specific message and HTTP status code.
     *
     * @param message The error message to be included with the exception.
     * @param code The HTTP status code representing the error type.
     */
    public AppException(String message, HttpStatus code) {
        super(message);
        this.code = code;
    }

    /**
     * Gets the HTTP status code associated with this exception.
     *
     * @return The HTTP status code.
     */
    public HttpStatus getCode() {
        return code;
    }
}
