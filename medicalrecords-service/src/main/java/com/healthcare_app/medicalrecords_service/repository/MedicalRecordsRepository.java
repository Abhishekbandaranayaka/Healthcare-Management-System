package com.healthcare_app.medicalrecords_service.repository;

import com.healthcare_app.medicalrecords_service.model.MedicalRecords;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * This interface represents the repository for managing MedicalRecords entities.
 * It extends MongoRepository to provide CRUD operations on the MedicalRecords collection in MongoDB.
 * The repository is automatically implemented by Spring Data MongoDB.
 *  * Author: P.K.N. Dharmasena
 *  * Date: 2024/07/27
 */
@Repository
public interface MedicalRecordsRepository extends MongoRepository<MedicalRecords, String> {
    // Additional query methods can be defined here if needed.
}
