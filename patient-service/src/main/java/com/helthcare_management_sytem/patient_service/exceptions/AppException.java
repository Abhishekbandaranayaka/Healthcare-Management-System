package com.helthcare_management_sytem.patient_service.exceptions;

import org.springframework.http.HttpStatus;

/**
 * Custom exception class for handling application-specific errors in the patient service.
 * This class extends RuntimeException to allow for unchecked exceptions that can be thrown
 * during the execution of the application. It includes an HTTP status code to convey
 * the error type in HTTP responses.
 *
 * <p>Using this exception class allows for more granular control over error handling
 * and provides meaningful feedback to clients consuming the API.</p>
 *
 * Author: B.T.M.A.S.D.B Rathnayaka
 * Date: 2024/08/28
 */
public class AppException extends RuntimeException {

    /**
     * The HTTP status code associated with this exception.
     * This code is used to indicate the type of error that occurred.
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
