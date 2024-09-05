package com.healthcare_app.appointment_service.exception;

import org.springframework.http.HttpStatus;

public class AppException extends RuntimeException{

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
