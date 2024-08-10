package com.healthcare_app.billing_service.repository;

import com.healthcare_app.billing_service.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment , Long> {
}
