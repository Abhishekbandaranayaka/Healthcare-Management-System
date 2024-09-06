package com.healthcare_app.medicalrecords_service.service;

import com.healthcare_app.medicalrecords_service.model.MedicalRecords;

import java.util.List;
import java.util.Optional;

/**
 * This interface defines the service layer methods for managing medical records.
 * It provides the contract for the operations that can be performed on medical records.
 *  * Author: P.K.N. Dharmasena
 *  * Date: 2024/07/27
 */
public interface MedicalRecordsService {

    /**
     * Retrieves all medical records.
     *
     * @return a list of all medical records.
     */
    List<MedicalRecords> getAllMedicalRecords();

    /**
     * Retrieves a specific medical record by its ID.
     *
     * @param id the ID of the medical record to retrieve.
     * @return an Optional containing the medical record if found, or empty if not found.
     */
    Optional<MedicalRecords> getMedicalRecordById(String id);

    /**
     * Creates a new medical record.
     *
     * @param medicalRecords the medical record to create.
     * @return a message indicating the result of the creation process.
     */
    String createMedicalReport(MedicalRecords medicalRecords);

    /**
     * Updates an existing medical record by its ID.
     *
     * @param id the ID of the medical record to update.
     * @param medicalRecordsDetails the updated details of the medical record.
     * @return a message indicating the result of the update process.
     */
    String updateMedicalRecord(String id, MedicalRecords medicalRecordsDetails);
}
