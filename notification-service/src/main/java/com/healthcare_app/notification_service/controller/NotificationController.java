package com.healthcare_app.notification_service.controller;

import com.healthcare_app.notification_service.model.Notification;
import com.healthcare_app.notification_service.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * The NotificationController class handles HTTP requests related to notifications.
 * It provides endpoints for sending and listing notifications.
 * * Author: S.T Fernando
 * *Date: 2024/07/29
 */
@RestController
@RequestMapping("/api/notifications")
public class NotificationController {
    @Autowired
    private NotificationService notificationService;
    /**
     * Sends a notification to a patient.
     *
     * @param patientId The ID of the patient to whom the notification is sent.
     * @param message   The message content of the notification.
     * @return A ResponseEntity containing a success message with the notification ID.
     */
    @PostMapping("/send")
    public ResponseEntity<String> sendNotification(@RequestParam Long patientId, @RequestParam String message) {
        Notification notification = notificationService.sendNotification(patientId, message);
        return ResponseEntity.ok("Notification sent successfully with ID: " + notification.getNotificationId());
    }
    /**
     * Lists all notifications.
     *
     * @return A ResponseEntity containing a list of all notifications.
     */
    @GetMapping("/list")
    public ResponseEntity<List<Notification>> listNotifications() {
        List<Notification> notifications = notificationService.listNotifications();
        return ResponseEntity.ok(notifications);
    }
}
