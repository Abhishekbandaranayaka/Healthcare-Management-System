package com.healthcare_app.appointment_service.service.Impl;

import com.healthcare_app.appointment_service.model.Notification;
import com.healthcare_app.appointment_service.repository.NotificationRepository;
import com.healthcare_app.appointment_service.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class NotificationServiceImpl implements NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    public void createNotification(Long patientId, Long doctorId, String message) {
        Notification notification = new Notification(null, patientId, doctorId, message, LocalDateTime.now());
        notificationRepository.save(notification);
    }


}
