package com.healthcare_app.notification_service.service;

import com.healthcare_app.notification_service.model.Notification;

import java.util.List;

public interface NotificationService {
    Notification sendNotification(Long patientId, String message);
    List<Notification> listNotifications();
    List<Notification> getNotificationsByPatientId(Long patientId);
}
