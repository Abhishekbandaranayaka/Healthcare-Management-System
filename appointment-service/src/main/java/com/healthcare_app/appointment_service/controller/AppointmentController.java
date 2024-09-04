package com.healthcare_app.appointment_service.controller;

import com.healthcare_app.appointment_service.model.Appointment;
import com.healthcare_app.appointment_service.service.AppointmentService;
import com.healthcare_app.appointment_service.util.AppointmentServiceConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing appointments.
 * Provides endpoints for CRUD operations on appointment entities.
 * Author: Ima Herath
 */
@RestController
@RequestMapping("/api/appointments")
@Validated
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    /**
     * Get all appointments.
     * @return List of all appointments.
     */
    @GetMapping
    public List<Appointment> getAllAppointments(){
        return appointmentService.getAllAppointments();
    }


    /**
     * Get an appointment by its ID.
     * @param id The ID of the appointment to retrieve.
     * @return ResponseEntity with the appointment if found, or a 404 status if not found.
     */
    @GetMapping("/{id}")
    public ResponseEntity<?> getAppointmentById(@PathVariable Long id) {
        Optional<Appointment> appointment = appointmentService.getAppointmentById(id);
        if (appointment.isPresent()) {
            return ResponseEntity.ok(appointment.get());
        } else {
            return ResponseEntity.status(AppointmentServiceConstants.STATUS_NOT_FOUND)
                    .body(AppointmentServiceConstants.APPOINTMENT_NOT_FOUND);
        }
    }

    /**
     * Book a new appointment.
     * @param appointment The appointment entity to create.
     * @return ResponseEntity with a success message.
     */
    @PostMapping("/create")
    public ResponseEntity<String> bookAppointment(@RequestBody Appointment appointment) {
        String message = appointmentService.bookAppointment(appointment);
        return ResponseEntity.status(AppointmentServiceConstants.STATUS_CREATED).body(message);
    }

    /**
     * Cancel an existing appointment.
     * @param id The ID of the appointment to cancel.
     * @return ResponseEntity with a success or failure message.
     */
    @PutMapping("git ")
    public ResponseEntity<String> cancelAppointment(@PathVariable Long id) {
        String message = appointmentService.cancelAppointment(id);
        if (message.equals(AppointmentServiceConstants.APPOINTMENT_CANCELLED_SUCCESSFULLY)) {
            return ResponseEntity.ok(message);
        } else {
            return ResponseEntity.status(AppointmentServiceConstants.STATUS_NOT_FOUND)
                    .body(AppointmentServiceConstants.APPOINTMENT_NOT_FOUND);
        }
    }

    /**
     * Update an existing appointment.
     * @param id The ID of the appointment to update.
     * @param appointment The updated appointment details.
     * @return ResponseEntity with a success or failure message.
     */
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateAppointment(@PathVariable Long id, @RequestBody Appointment appointment) {
        String message = appointmentService.updateAppointment(id, appointment);
        if (message.equals(AppointmentServiceConstants.APPOINTMENT_UPDATED_SUCCESSFULLY)) {
            return ResponseEntity.ok(message);
        } else {
            return ResponseEntity.status(AppointmentServiceConstants.STATUS_NOT_FOUND)
                    .body(AppointmentServiceConstants.APPOINTMENT_NOT_FOUND);
        }
    }


}
