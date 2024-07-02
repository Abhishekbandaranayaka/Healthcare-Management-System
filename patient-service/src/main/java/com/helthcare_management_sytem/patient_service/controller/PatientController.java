package com.helthcare_management_sytem.patient_service.controller;

import com.helthcare_management_sytem.patient_service.model.Patient;
import com.helthcare_management_sytem.patient_service.service.PatientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/patients")

public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping
    public List<Patient> getAllPatients(){
        return patientService.getAllPatients();
    }

    @GetMapping("/id")
    public ResponseEntity<?> getParentById(@PathVariable Long id){
        Optional<Patient> patient = patientService.getParentById(id);
        if (patient.isPresent()){
            return ResponseEntity.ok(patient.get());
        } else {
            return ResponseEntity.status(404).body("Patient not found");
        }
    }

    @PostMapping("/create")
    public ResponseEntity<String> savePatient(@RequestBody Patient patient){
        String message = patientService.savePatient(patient);
        return ResponseEntity.status(201).body(message);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updatePatient(@PathVariable Long id , @RequestBody Patient patient){
        String message = patientService.updatePatient(id, patient);
        if (message.equals("Patient update successfully")){
            return ResponseEntity.ok(message);
        } else {
            return ResponseEntity.status(404).body(message);
        }
    }

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
