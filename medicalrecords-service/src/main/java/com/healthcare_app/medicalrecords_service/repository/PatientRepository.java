package com.healthcare_app.medicalrecords_service.repository;

import com.healthcare_app.medicalrecords_service.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient , Long> {
}
