package com.healthcare_app.doctor_service.repository;

import com.healthcare_app.doctor_service.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Repository interface for the Doctor entity.
 * Extends JpaRepository to provide CRUD operations and query methods for Doctor entities.
 * Author: R.A.U.K.WIJESEKARA
 */
public interface DoctorRepository extends JpaRepository<Doctor, Long> {

    List<Doctor> findByFirstName(String firstName);

}

