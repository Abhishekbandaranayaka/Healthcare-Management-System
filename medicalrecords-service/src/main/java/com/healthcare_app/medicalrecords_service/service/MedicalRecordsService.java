package com.healthcare_app.medicalrecords_service.service;

import com.healthcare_app.medicalrecords_service.model.MedicalRecords;
import com.healthcare_app.medicalrecords_service.repository.MedicalRecordsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * This service class handles the business logic for managing medical records.
 * It interacts with the MedicalRecordsRepository to perform CRUD operations.
 */

@Service
public class MedicalRecordsService {

    @Autowired
    private MedicalRecordsRepository medicalRecordsRepository;

    //Retrieve all medical records.
    public List<MedicalRecords> getAllMedicalRecords() {
        return medicalRecordsRepository.findAll();
    }
    //Retrieve a medical record by its ID.
    public Optional<MedicalRecords> getMedicalRecordById(String id) {
        return medicalRecordsRepository.findById(id);
    }

    //Create a new medical record.
    public String createMedicalReport(MedicalRecords medicalRecords){
        medicalRecordsRepository.save(medicalRecords);
        return "Medical-record created successfully";
    }

    //Update an existing medical record by its ID.
    public String updateMedicalRecord(String id , MedicalRecords medicalRecordsDetails){
        Optional<MedicalRecords> optionalMedicalRecords = medicalRecordsRepository.findById(id);
        if (optionalMedicalRecords.isPresent()){
            MedicalRecords medicalRecords = optionalMedicalRecords.get();
            medicalRecords.setPatientId(medicalRecords.getPatientId());
            medicalRecords.setMedicalHistory(medicalRecordsDetails.getMedicalHistory());
            medicalRecords.setDiagnosis(medicalRecordsDetails.getDiagnosis());
            medicalRecords.setTreatments(medicalRecordsDetails.getTreatments());
            medicalRecordsRepository.save(medicalRecords);
            return "Medical-record updated successfully";
        } else {
            return "Medical-record not found";
        }
    }
}
