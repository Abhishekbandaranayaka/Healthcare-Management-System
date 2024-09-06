package com.healthcare_app.appointment_service.repository;

import com.healthcare_app.appointment_service.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository interface for managing Appointment entities.
 * Extends JpaRepository to provide CRUD operations and query methods for Appointment entities.
 *
 * Author: Ima Herath
 */
@Repository
public interface AppointmentRepository extends JpaRepository<Appointment , Long> {

    List<Appointment> findByStatus(String status);

}
