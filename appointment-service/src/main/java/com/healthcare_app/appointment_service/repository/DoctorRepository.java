package com.healthcare_app.appointment_service.repository;

import com.healthcare_app.appointment_service.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor , Long> {
}
