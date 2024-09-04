package com.healthcare_app.appointment_service.util;

public class AppointmentServiceConstants {

        // Error messages
        public static final String INVALID_PATIENT_ID = "Invalid Patient ID";
        public static final String INVALID_DOCTOR_ID = "Invalid Doctor ID";
        public static final String APPOINTMENT_NOT_FOUND = "Appointment not found";

        // Success messages
        public static final String APPOINTMENT_BOOKED_SUCCESSFULLY = "Appointment booked successfully";
        public static final String APPOINTMENT_CANCELLED_SUCCESSFULLY = "Appointment cancelled successfully";
        public static final String APPOINTMENT_UPDATED_SUCCESSFULLY = "Appointment updated successfully";

        // Notification messages
        public static final String APPOINTMENT_CREATED_NOTIFICATION = "Your appointment is created successfully.";
        public static final String APPOINTMENT_CANCELLED_NOTIFICATION = "Your appointment has been cancelled.";
        public static final String APPOINTMENT_UPDATED_NOTIFICATION = "Your appointment has been updated.";

        // Status constants
        public static final String STATUS_CANCELLED = "canceled";

        // HTTP Status Codes
        public static final int STATUS_CREATED = 201;
        public static final int STATUS_NOT_FOUND = 404;

}
