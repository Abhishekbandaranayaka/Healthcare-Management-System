package com.helthcare_management_sytem.patient_service.service.Impl;

import com.helthcare_management_sytem.patient_service.exceptions.AppException;
import com.helthcare_management_sytem.patient_service.model.Patient;
import com.helthcare_management_sytem.patient_service.repository.PatientRepository;
import com.helthcare_management_sytem.patient_service.service.PatientService;
import com.helthcare_management_sytem.patient_service.util.PatientServiceConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
public class PatientServiceImpl implements PatientService {

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
        try {
            patientRepository.save(patient);
            return PatientServiceConstants.PATIENT_SAVED_SUCCESSFULLY;
        }catch (Exception e){
            throw new AppException("Error Saving Patient", HttpStatus.INTERNAL_SERVER_ERROR);
        }
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
            return PatientServiceConstants.PATIENT_UPDATE_SUCCESSFULLY;
        } else {
            throw new AppException(PatientServiceConstants.PATIENT_NOT_FOUND,HttpStatus.NOT_FOUND);
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
            return PatientServiceConstants.PATIENT_DELETE_SUCCESSFULLY;
        } else {
            throw new AppException(PatientServiceConstants.PATIENT_NOT_FOUND,HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Find patients by name.
     * @param name The name of the patient to search for.
     * @return List of patients with the given name.
     */
    public List<Patient> findByName(String name) {
        List<Patient> patients = patientRepository.findByName(name);
        if (patients.isEmpty()) {
            throw new AppException(PatientServiceConstants.PATIENT_NOT_FOUND, HttpStatus.NOT_FOUND);
        }
        return patients;
    }
}
