package com.healthcare_app.billing_service.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;

/**
 * The Notification class represents a notification entity that is stored in the MongoDB database.
 * It contains information about notifications sent to patients.
 */
@Document(collection = "notifications")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Notification {

    /**
     * The unique identifier for the notification.
     */
    @Id
    private String notificationId;
    /**
     * The ID of the patient to whom the notification is sent.
     * This field is mandatory.
     */
    @NotNull(message = "Patient ID is mandatory")
    @Field("patient_id")
    private Long patientId;
    /**
     * The message content of the notification.
     * This field is mandatory.
     */
    @NotNull(message = "Doctor ID is mandatory")
    @Field("doctor_id")
    private Long doctorId;
    /**
     * The message content of the notification.
     * This field is mandatory.
     */
    @NotBlank(message = "Message is mandatory")
    @Field("message")
    private String message;
    /**
     * The date and time when the notification was created.
     */
    @Field("notification_date")
    private LocalDateTime notificationDate;

}
