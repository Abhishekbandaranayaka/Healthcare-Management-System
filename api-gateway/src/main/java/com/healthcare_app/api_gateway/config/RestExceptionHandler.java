package com.healthcare_app.api_gateway.config;

import com.healthcare_app.api_gateway.dto.ErrorDto;
import com.healthcare_app.api_gateway.exceptions.AppException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Global exception handler for handling exceptions across the whole application.
 * This class uses @ControllerAdvice to provide centralized exception handling
 * and formats error responses for custom exceptions.
 *
 * Author: B.T.M.A.S.D.B Rathnayaka
 * Date: 2024/07/29
 */
@ControllerAdvice
public class RestExceptionHandler {

    /**
     * Handles custom application exceptions (AppException) and returns a formatted error response.
     * The exception's status code and message are used to build the error response.
     *
     * @param ex The custom exception to handle.
     * @return A ResponseEntity containing the error details and appropriate HTTP status code.
     */
    @ExceptionHandler(value = {AppException.class})
    @ResponseBody
    public ResponseEntity<ErrorDto> handleException(AppException ex) {
        // Build and return an error response with the status code and message from the exception
        return ResponseEntity.status(ex.getCode())
                .body(ErrorDto.builder()
                        .message(ex.getMessage())
                        .build());
    }
}
