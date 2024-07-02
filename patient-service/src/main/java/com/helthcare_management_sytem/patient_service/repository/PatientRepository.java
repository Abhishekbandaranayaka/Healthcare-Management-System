package com.helthcare_management_sytem.patient_service.repository;

import com.helthcare_management_sytem.patient_service.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient , Long> {
}
