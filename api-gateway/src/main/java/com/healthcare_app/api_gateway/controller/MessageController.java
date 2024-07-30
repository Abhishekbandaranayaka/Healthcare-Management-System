package com.healthcare_app.api_gateway.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * Controller for handling requests related to messages.
 * Provides an endpoint to retrieve a list of predefined messages.
 *
 * Author: B.T.M.A.S.D.B Rathnayaka
 * Date: 2024/07/29
 */
@RestController
public class MessageController {

    /**
     * Handles GET requests to retrieve a list of messages.
     *
     * @return A ResponseEntity containing a list of predefined messages.
     */
    @GetMapping("/messages")
    public ResponseEntity<List<String>> messages() {
        // Define a list of messages
        List<String> messages = Arrays.asList("first", "second");

        // Return the list of messages with an HTTP 200 OK status
        return ResponseEntity.ok(messages);
    }
}
