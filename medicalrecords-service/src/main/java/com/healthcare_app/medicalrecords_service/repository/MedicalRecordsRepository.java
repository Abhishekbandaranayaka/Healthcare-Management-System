package com.healthcare_app.medicalrecords_service.repository;

import com.healthcare_app.medicalrecords_service.model.MedicalRecords;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * This interface serves as the repository for managing medical records.
 * It extends MongoRepository to provide CRUD operations for the MedicalRecords entity.
 */
@Repository
public interface MedicalRecordsRepository extends MongoRepository<MedicalRecords , String> {
}
