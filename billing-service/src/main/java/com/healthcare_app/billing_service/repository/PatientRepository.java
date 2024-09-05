package com.healthcare_app.billing_service.repository;

import com.healthcare_app.billing_service.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient , Long> {
}
