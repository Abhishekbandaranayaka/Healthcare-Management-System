package com.healthcare_app.doctor_service.exception;
import org.springframework.http.HttpStatus;

/**
 * Author : R.A.U.K.Wijesekara
 * Custom exception class for handling application-specific errors.
 * Extends {@link RuntimeException} to provide more control over error handling
 * in the healthcare application.
 */
public class AppException extends RuntimeException {

    /**
     * HTTP status code associated with the exception.
     */
    private final HttpStatus code;

    /**
     * Constructs a new {@code AppException} with the specified detail message and HTTP status code.
     *
     * @param message the detail message (which is saved for later retrieval by the {@link #getMessage()} method)
     * @param code the HTTP status code associated with the exception (which is saved for later retrieval by the {@link #getCode()} method)
     */
    public AppException(String message, HttpStatus code) {
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
