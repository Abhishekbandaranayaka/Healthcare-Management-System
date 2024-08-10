package com.helthcare_management_sytem.patient_service.service;

import com.helthcare_management_sytem.patient_service.model.Patient;
import com.helthcare_management_sytem.patient_service.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service class for managing Patient entities.
 * Provides methods for CRUD operations and business logic.
 *  * Author: B.T.M.A.S.D.B Rathnayaka
 *  * Date: 2024/07/01
 */
@Service
public class PatientServiceImpl implements PatientService{

    @Autowired
    private PatientRepository patientRepository;

    /**
     * Retrieve all patients from the database.
     * @return List of all patients.
     */
    public List<Patient> getAllPatients(){
        return patientRepository.findAll();
    }

    /**
     * Retrieve a patient by its ID.
     * @param id The ID of the patient to retrieve.
     * @return An Optional containing the patient if found, or empty if not found.
     */
    public Optional<Patient> getPatientById(Long id){
        return patientRepository.findById(id);
    }

    /**
     * Save a new patient to the database.
     * @param patient The patient entity to save.
     * @return A success message.
     */
    public String savePatient(Patient patient){
        patientRepository.save(patient);
        return "Patient saved successfully";
    }

    /**
     * Update an existing patient in the database.
     * @param id The ID of the patient to update.
     * @param patientDetails The updated patient details.
     * @return A success or failure message.
     */
    public String updatePatient(Long id,Patient patientDetails){
        Optional<Patient> optionalPatient= patientRepository.findById(id);
        if (optionalPatient.isPresent()){
            Patient patient = optionalPatient.get();
            patient.setName(patientDetails.getName());
            patient.setAddress(patientDetails.getAddress());
            patient.setPhoneNumber(patientDetails.getPhoneNumber());
            patient.setEmail(patientDetails.getEmail());
            patientRepository.save(patient);
            return "Patient update successfully";
        } else {
            return "Patient not found!";
        }
    }

    /**
     * Delete a patient from the database.
     * @param id The ID of the patient to delete.
     * @return A success or failure message.
     */
    public String deletePatient(Long id){
        if (patientRepository.existsById(id)){
            patientRepository.deleteById(id);
            return "Patient delete successfully";
        } else {
            return "Patient not found";
        }
    }
}
