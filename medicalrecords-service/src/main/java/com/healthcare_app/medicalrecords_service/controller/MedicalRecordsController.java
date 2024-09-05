package com.healthcare_app.medicalrecords_service.controller;

import com.healthcare_app.medicalrecords_service.exceptions.AppException;
import com.healthcare_app.medicalrecords_service.model.MedicalRecords;
import com.healthcare_app.medicalrecords_service.service.MedicalRecordsService;
import com.healthcare_app.medicalrecords_service.util.MedicalRecordsConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * This is the controller class for managing medical records.
 * It handles HTTP requests related to medical records, including retrieving, creating, and updating records.
 *  * Author: P.K.N. Dharmasena
 *  * Date: 2024/07/27
 */
@RestController
@RequestMapping("/api/medical_records")
@Validated
public class MedicalRecordsController {

    // Injecting the MedicalRecordsService to handle the business logic.
    @Autowired
    private MedicalRecordsService medicalRecordsService;

    // Exception handler for AppException, capturing any exceptions thrown in this controller
    // and returning an appropriate HTTP status and message.
    @ExceptionHandler(AppException.class)
    public ResponseEntity<String> handleAppException(AppException ex) {
        return ResponseEntity.status(ex.getCode()).body(ex.getMessage());
    }
    /**
     * Retrieves all medical records.
     *
     * @return a list of all medical records.
     */

    @GetMapping
    public List<MedicalRecords> getAllMedicalRecords() {
        return medicalRecordsService.getAllMedicalRecords();
    }

    /**
     * Retrieves a specific medical record by its ID.
     *
     * @param id the ID of the medical record to retrieve.
     * @return the medical record if found, or a 404 status if not found.
     */
    @GetMapping("/{id}")
    public ResponseEntity<?> getMedicalRecordById(@PathVariable String id) {
        Optional<MedicalRecords> medicalRecord = medicalRecordsService.getMedicalRecordById(id);
        if (medicalRecord.isPresent()) {
            return ResponseEntity.ok(medicalRecord.get());
        } else {
            return ResponseEntity.status(404).body(MedicalRecordsConstants.Medical_record_not_found);
        }
    }

    /**
     * Creates a new medical record.
     *
     * @param medicalRecords the medical record to create.
     * @return a message indicating the result of the creation process.
     */
    @PostMapping("/create")
    public ResponseEntity<String> createMedicalReport(@RequestBody MedicalRecords medicalRecords) {
        String message = medicalRecordsService.createMedicalReport(medicalRecords);
        return ResponseEntity.ok(message);
    }

    /**
     * Updates an existing medical record by its ID.
     *
     * @param id the ID of the medical record to update.
     * @param medicalRecords the updated medical record details.
     * @return a message indicating the result of the update process, or a 404 status if the record was not found.
     */
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateMedicalRecord(@PathVariable String id, @RequestBody MedicalRecords medicalRecords) {
        String message = medicalRecordsService.updateMedicalRecord(id, medicalRecords);
        if (message.equals(MedicalRecordsConstants.Medical_record_updated_successfully)){
            return ResponseEntity.ok(message);
        } else {
            return ResponseEntity.status(404).body(message);
        }
    }
}
