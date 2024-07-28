package com.healthcare_app.doctor_service.repository;

import com.healthcare_app.doctor_service.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}
