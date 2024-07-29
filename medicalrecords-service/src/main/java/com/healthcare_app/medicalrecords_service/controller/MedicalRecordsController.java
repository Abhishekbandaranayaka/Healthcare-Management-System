package com.healthcare_app.medicalrecords_service.controller;

import com.healthcare_app.medicalrecords_service.model.MedicalRecords;
import com.healthcare_app.medicalrecords_service.service.MedicalRecordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * This class is the REST controller for managing medical records.
 * It handles HTTP requests and interacts with the MedicalRecordsService to perform CRUD operations.
 */

@RestController
@RequestMapping("/api/medical_records")
@Validated
public class MedicalRecordsController {

    @Autowired
    private MedicalRecordsService medicalRecordsService;

    //Get all medical records.
    @GetMapping
    public List<MedicalRecords> getAllMedicalRecords() {
        return medicalRecordsService.getAllMedicalRecords();
    }

    //Get a medical record by its ID.
    @GetMapping("/{id}")
    public ResponseEntity<?> getMedicalRecordById(@PathVariable String id) {
        Optional<MedicalRecords> medicalRecord = medicalRecordsService.getMedicalRecordById(id);
        if (medicalRecord.isPresent()) {
            return ResponseEntity.ok(medicalRecord.get());
        } else {
            return ResponseEntity.status(404).body("Medical record not found");
        }
    }

    //Create a new medical record.
    @PostMapping("/create")
     public ResponseEntity<String> createMedicalReport(@RequestBody MedicalRecords medicalRecords){
        String message = medicalRecordsService.createMedicalReport(medicalRecords);
        return ResponseEntity.ok(message);
     }

    //Update an existing medical record by its ID.
     @PutMapping("/update/{id}")
    public ResponseEntity<String> updateMedicalRecord(@PathVariable String id ,@RequestBody MedicalRecords medicalRecords){
        String message = medicalRecordsService.updateMedicalRecord(id, medicalRecords);
        if(message.equals("Medical-record updated successfully")){
            return ResponseEntity.ok(message);
        } else {
            return ResponseEntity.status(404).body(message);
        }
     }

}
