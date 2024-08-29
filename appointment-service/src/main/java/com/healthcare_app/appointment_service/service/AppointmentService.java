package com.healthcare_app.appointment_service.service;

import com.healthcare_app.appointment_service.model.Appointment;

import java.util.List;
import java.util.Optional;

/**
 * Service interface for managing Appointment service.
 * Provides methods for CRUD operations and business logic.
 *  * Author: Ima Herath
 */
public interface AppointmentService {

    List<Appointment> getAllAppointments();
    Optional<Appointment> getAppointmentById(Long id);
    String bookAppointment(Appointment appointment);
    String cancelAppointment(Long id);
    String updateAppointment(Long id,Appointment appointmentDetails);
}
