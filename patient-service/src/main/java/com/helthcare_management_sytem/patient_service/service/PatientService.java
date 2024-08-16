package com.helthcare_management_sytem.patient_service.service;

import com.helthcare_management_sytem.patient_service.model.Patient;

import java.util.List;
import java.util.Optional;

/**
 * Service interface for managing Patient entities.
 * Provides methods for CRUD operations and business logic.
 *  * Author: B.T.M.A.S.D.B Rathnayaka
 *  * Date: 2024/08/10
 */
public interface PatientService {
    List<Patient> getAllPatients();

    Optional<Patient> getPatientById(Long id);

    String savePatient(Patient patient);

    String updatePatient(Long id, Patient patientDetails);

    String deletePatient(Long id);
}
