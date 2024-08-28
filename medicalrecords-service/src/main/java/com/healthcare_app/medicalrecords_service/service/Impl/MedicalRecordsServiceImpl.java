package com.healthcare_app.medicalrecords_service.service.Impl;

import com.healthcare_app.medicalrecords_service.model.MedicalRecords;
import com.healthcare_app.medicalrecords_service.repository.MedicalRecordsRepository;
import com.healthcare_app.medicalrecords_service.service.MedicalRecordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * This class implements the MedicalRecordsService interface and provides
 * the actual business logic for managing medical records.
 *  * Author: P.K.N. Dharmasena
 *  * Date: 2024/07/27
 */
@Service
public class MedicalRecordsServiceImpl implements MedicalRecordsService {

    // Injecting the MedicalRecordsRepository to interact with the database.
    @Autowired
    private MedicalRecordsRepository medicalRecordsRepository;

    /**
     * Retrieves all medical records from the database.
     *
     * @return a list of all medical records.
     */
    public List<MedicalRecords> getAllMedicalRecords() {
        return medicalRecordsRepository.findAll();
    }

    /**
     * Retrieves a specific medical record by its ID.
     *
     * @param id the ID of the medical record to retrieve.
     * @return an Optional containing the medical record if found, or empty if not found.
     */
    public Optional<MedicalRecords> getMedicalRecordById(String id) {
        return medicalRecordsRepository.findById(id);
    }

    /**
     * Creates a new medical record in the database.
     *
     * @param medicalRecords the medical record to create.
     * @return a message indicating the result of the creation process.
     */
    public String createMedicalReport(MedicalRecords medicalRecords) {
        medicalRecordsRepository.save(medicalRecords);
        return "Medical-record created successfully";
    }

    /**
     * Updates an existing medical record by its ID.
     *
     * @param id the ID of the medical record to update.
     * @param medicalRecordsDetails the updated details of the medical record.
     * @return a message indicating the result of the update process,
     * or a message indicating that the record was not found.
     */
    public String updateMedicalRecord(String id, MedicalRecords medicalRecordsDetails) {
        Optional<MedicalRecords> optionalMedicalRecords = medicalRecordsRepository.findById(id);
        if (optionalMedicalRecords.isPresent()) {
            // If the medical record is found, update its details.
            MedicalRecords medicalRecords = optionalMedicalRecords.get();
            medicalRecords.setPatientId(medicalRecords.getPatientId());
            medicalRecords.setMedicalHistory(medicalRecordsDetails.getMedicalHistory());
            medicalRecords.setDiagnosis(medicalRecordsDetails.getDiagnosis());
            medicalRecords.setTreatments(medicalRecordsDetails.getTreatments());
            medicalRecordsRepository.save(medicalRecords);
            return "Medical-record updated successfully";
        } else {
            // If the medical record is not found, return a not found message.
            return "Medical-record not found";
        }
    }
}
