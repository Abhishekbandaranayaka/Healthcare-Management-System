package com.healthcare_app.api_gateway.repository;

import com.healthcare_app.api_gateway.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient , Long> {
}
