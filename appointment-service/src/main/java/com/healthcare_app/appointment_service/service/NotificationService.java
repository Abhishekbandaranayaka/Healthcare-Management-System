package com.healthcare_app.appointment_service.service;

public interface NotificationService {
    void createNotification(Long patientId, Long doctorId, String message);
}
