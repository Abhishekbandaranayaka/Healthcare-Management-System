package com.healthcare_app.appointment_service.controller;

import com.healthcare_app.appointment_service.model.Appointment;
import com.healthcare_app.appointment_service.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/appointments")
@Validated
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @GetMapping
    public List<Appointment> getAllAppointments(){
        return appointmentService.getAllAppointments();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getAppointmentById(@PathVariable Long id){
        Optional<Appointment> appointment = appointmentService.getAppointmentById(id);
        if (appointment.isPresent()){
            return ResponseEntity.ok(appointment.get());
        } else {
            return ResponseEntity.status(404).body("Appointment not found");
        }
    }

    @PostMapping("/create")
    public ResponseEntity<String> bookAppointment(@RequestBody Appointment appointment){
        String message = appointmentService.bookAppointment(appointment);
        return ResponseEntity.status(201).body(message);
    }

    @PutMapping("/cancel/{id}")
    public ResponseEntity<String> cancelAppointment(@PathVariable Long id){
        String message = appointmentService.cancelAppointment(id);
        if (message.equals("Appointment cancelled successfully")){
            return ResponseEntity.ok(message);
        } else {
            return ResponseEntity.status(404).body(message);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateAppointment(@PathVariable Long id,@RequestBody Appointment appointment){
        String message = appointmentService.updateAppointment(id, appointment);
        if (message.equals("Appointment updated Successfully")){
            return ResponseEntity.ok(message);
        } else {
            return ResponseEntity.status(404).body(message);
        }
    }

}
