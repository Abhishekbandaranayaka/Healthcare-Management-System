package com.healthcare_app.appointment_service.repository;

import com.healthcare_app.appointment_service.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for managing Appointment entities.
 * Extends JpaRepository to provide CRUD operations and query methods for Appointment entities.
 *
 * Author: [Your Name]
 * Date: 2024/08/09
 */

public interface AppointmentRepository extends JpaRepository<Appointment , Long> {
}
