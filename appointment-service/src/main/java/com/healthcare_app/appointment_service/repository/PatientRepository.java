package com.healthcare_app.appointment_service.repository;

import com.healthcare_app.appointment_service.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient , Long> {
}
