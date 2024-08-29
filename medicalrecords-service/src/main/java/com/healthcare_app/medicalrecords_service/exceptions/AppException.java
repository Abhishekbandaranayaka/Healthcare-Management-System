package com.healthcare_app.medicalrecords_service.exceptions;

import org.springframework.http.HttpStatus;

/**
 * Custom exception class that extends RuntimeException.
 * This class is used to handle application-specific exceptions
 * with an associated HTTP status code.
 *  * Author: P.K.N. Dharmasena
 *  * Date: 2024/08/30
 */
public class AppException extends RuntimeException {

    // HTTP status code associated with the exception
    private final HttpStatus code;

    /**
     * Constructor for creating an AppException with a message and an HTTP status code.
     *
     * @param message The detailed error message.
     * @param code    The HTTP status code to be associated with the exception.
     */
    public AppException(String message, HttpStatus code) {
        super(message);  // Pass the error message to the superclass (RuntimeException)
        this.code = code; // Set the HTTP status code for this exception
    }

    /**
     * Getter method to retrieve the HTTP status code associated with the exception.
     *
     * @return The HTTP status code.
     */
    public HttpStatus getCode() {
        return code;
    }
}
