package com.healthcare_app.appointment_service.repository;

import com.healthcare_app.appointment_service.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor , Long> {
}
