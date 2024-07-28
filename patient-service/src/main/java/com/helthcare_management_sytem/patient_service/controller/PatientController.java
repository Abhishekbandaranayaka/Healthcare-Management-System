package com.helthcare_management_sytem.patient_service.controller;

import com.helthcare_management_sytem.patient_service.model.Patient;
import com.helthcare_management_sytem.patient_service.service.PatientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing patients.
 * Provides endpoints for CRUD operations on patient entities.
 *  * Author: B.T.M.A.S.D.B Rathnayaka
 *  * Date: 2024/07/01
 */
@RestController
@RequestMapping("/api/patients")

public class PatientController {

    @Autowired
    private PatientService patientService;

    /**
     * Get all patients.
     * @return List of all patients.
     */
    @GetMapping
    public List<Patient> getAllPatients(){
        return patientService.getAllPatients();
    }

    /**
     * Get a patient by ID.
     * @param id The ID of the patient to retrieve.
     * @return ResponseEntity with the patient if found, or a 404 status if not found.
     */
    @GetMapping("/id")
    public ResponseEntity<?> getPatientById(@PathVariable Long id){
        Optional<Patient> patient = patientService.getPatientById(id);
        if (patient.isPresent()){
            return ResponseEntity.ok(patient.get());
        } else {
            return ResponseEntity.status(404).body("Patient not found");
        }
    }

    /**
     * Create a new patient.
     * @param patient The patient entity to create.
     * @return ResponseEntity with a success message.
     */
    @PostMapping("/create")
    public ResponseEntity<String> savePatient(@RequestBody @Valid Patient patient){
        String message = patientService.savePatient(patient);
        return ResponseEntity.status(201).body(message);
    }

    /**
     * Update an existing patient.
     * @param id The ID of the patient to update.
     * @param patient The updated patient details.
     * @return ResponseEntity with a success or failure message.
     */
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updatePatient(@PathVariable Long id , @RequestBody Patient patient){
        String message = patientService.updatePatient(id, patient);
        if (message.equals("Patient update successfully")){
            return ResponseEntity.ok(message);
        } else {
            return ResponseEntity.status(404).body(message);
        }
    }

    /**
     * Delete a patient.
     * @param id The ID of the patient to delete.
     * @return ResponseEntity with a success or failure message.
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletePatient(@PathVariable Long id){
        String message = patientService.deletePatient(id);
        if (message.equals("Patient delete successfully")){
            return ResponseEntity.ok(message);
        } else {
            return ResponseEntity.status(404).body(message);
        }
    }
}