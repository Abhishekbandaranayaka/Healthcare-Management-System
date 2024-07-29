package com.healthcare_app.api_gateway.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * Data Transfer Object (DTO) for representing error messages.
 * Used to convey error details in API responses.
 *
 * Author: B.T.M.A.S.D.B Rathnayaka
 * Date: 2024/07/29
 */
@AllArgsConstructor
@Builder
@Data
public class ErrorDto {

    /**
     * The error message to be returned in the API response.
     * Provides details about the nature of the error.
     */
    private String message;
}
