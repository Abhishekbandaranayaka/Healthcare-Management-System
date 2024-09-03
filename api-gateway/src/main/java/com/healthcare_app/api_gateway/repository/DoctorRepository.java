package com.healthcare_app.api_gateway.repository;

import com.healthcare_app.api_gateway.entities.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor , Long> {
}
