package com.healthcare_app.appointment_service.repository;

import com.healthcare_app.appointment_service.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment , Long> {
}
