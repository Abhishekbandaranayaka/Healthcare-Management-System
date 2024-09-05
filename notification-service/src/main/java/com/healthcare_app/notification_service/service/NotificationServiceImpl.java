package com.healthcare_app.notification_service.service;

import com.healthcare_app.notification_service.model.Notification;
import com.healthcare_app.notification_service.repository.NotificationRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.logging.Logger;

@Service
public class NotificationServiceImpl implements NotificationService {


//    private static final Logger logger = (Logger) LoggerFactory.getLogger(NotificationService.class);

    @Autowired
    private NotificationRepository notificationRepository;
    /**
     * Sends a notification to a specific patient by saving it in the database.
     *
     * @param patientId The ID of the patient to whom the notification is sent.
     * @param message   The message content of the notification.
     * @return The saved Notification object.
     */
    public Notification sendNotification(Long patientId, String message) {
        Notification notification = new Notification();
        notification.setPatientId(patientId);
        notification.setMessage(message);
        notification.setNotificationDate(LocalDateTime.now());
        return notificationRepository.save(notification);
    }
    /**
     * Retrieves a list of all notifications from the database.
     *
     * @return A list of Notification objects.
     */
    public List<Notification> listNotifications() {
        return notificationRepository.findAll();
    }
    /**
     * Retrieves a list of notifications for a specific patient by their ID.
     *
     * @param patientId The ID of the patient whose notifications are to be retrieved.
     * @return A list of Notification objects for the specified patient.
     */
    public List<Notification> getNotificationsByPatientId(Long patientId){
        return notificationRepository.findByPatientId(patientId);
    }


}