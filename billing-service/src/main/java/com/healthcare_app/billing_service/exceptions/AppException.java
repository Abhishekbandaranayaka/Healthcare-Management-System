package com.healthcare_app.billing_service.exceptions;

import org.springframework.http.HttpStatus;

/**
 * Custom exception class for the healthcare billing service.
 * This exception is used to handle application-specific errors and provides
 * a custom HTTP status code and error message.
 *
 * Author: A.A.M.C Abesinghe
 * Date: 2024/09/02
 */
public class AppException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    private final HttpStatus code;

    /**
     * Constructs a new AppException with the specified HTTP status code and error message.
     *
     * @param code the HTTP status code
     * @param message the error message
     */
    public AppException(HttpStatus code, String message) {
        super(message);
        this.code = code;
    }

    /**
     * Returns the HTTP status code associated with this exception.
     *
     * @return the HTTP status code
     */
    public HttpStatus getCode() {
        return code;
    }
}
