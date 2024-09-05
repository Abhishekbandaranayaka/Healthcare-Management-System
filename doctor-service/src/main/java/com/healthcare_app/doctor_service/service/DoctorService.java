package com.healthcare_app.doctor_service.service;

import com.healthcare_app.doctor_service.model.Doctor;

import java.util.List;
import java.util.Optional;

/**
 * The Service interface for managing Doctor entities.
 * This Provides methods for CRUD operations and business logics.
 * Author: R.A.U.K.Wijesekara
 */
public interface DoctorService {
    List<Doctor> getAllDoctors();

    Optional<Doctor> getDoctorById(Long id);

    List<Doctor> findByName(String name);

    String saveDoctor(Doctor doctor);

    String updateDoctor(Long id, Doctor patientDetails);

    String deleteDoctor(Long id);
}
