package com.healthcare_app.medicalrecords_service.service.Impl;

import com.healthcare_app.medicalrecords_service.exceptions.AppException;
import com.healthcare_app.medicalrecords_service.model.MedicalRecords;
import com.healthcare_app.medicalrecords_service.model.Patient;
import com.healthcare_app.medicalrecords_service.repository.MedicalRecordsRepository;
import com.healthcare_app.medicalrecords_service.repository.PatientRepository;
import com.healthcare_app.medicalrecords_service.service.MedicalRecordsService;
import com.healthcare_app.medicalrecords_service.util.MedicalRecordsConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @Autowired
    private PatientRepository patientRepository;

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
     * @throws AppException If there's an error during the creation process.
     */
    public String createMedicalReport(MedicalRecords medicalRecords) {
        try {
            // Check if the patient exists
            Optional<Patient> existingPatient = patientRepository.findById(medicalRecords.getPatientId());

            if (existingPatient.isEmpty()) {
                // Create and save the new patient if it doesn't exist
                Patient newPatient = new Patient();
                newPatient.setId(medicalRecords.getPatientId()); // Set patient ID (Adjust as needed)
                // Optionally set other patient details if available
                patientRepository.save(newPatient);
            }

            // Save the new medical record to the database
            medicalRecordsRepository.save(medicalRecords);
            return MedicalRecordsConstants.Medical_record_created_successfully;
        } catch (Exception e) {
            throw new AppException("Error creating Medical-record", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Updates an existing medical record by its ID.
     *
     * @param id the ID of the medical record to update.
     * @param medicalRecordsDetails the updated details of the medical record.
     * @return A success message if the record is updated successfully.
     * @throws AppException If the medical record is not found or an error occurs during the update.
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
            medicalRecordsRepository.save(medicalRecords);// Save the updated record to the database
            return MedicalRecordsConstants.Medical_record_updated_successfully;
        } else {
            // Throw a custom exception if the medical record is not found
            throw new AppException(MedicalRecordsConstants.Medical_record_not_found,HttpStatus.NOT_FOUND);
        }
    }
}
