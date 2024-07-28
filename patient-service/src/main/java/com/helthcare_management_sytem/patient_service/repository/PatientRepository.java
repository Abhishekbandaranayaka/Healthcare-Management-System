package com.helthcare_management_sytem.patient_service.repository;

import com.helthcare_management_sytem.patient_service.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for the Patient entity.
 * Extends JpaRepository to provide CRUD operations and query methods.
 *  * Author: B.T.M.A.S.D.B Rathnayaka
 *  * Date: 2024/07/01
 */
public interface PatientRepository extends JpaRepository<Patient , Long> {
}
