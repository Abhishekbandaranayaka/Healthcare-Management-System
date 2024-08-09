package com.healthcare_app.billing_service.repository;

import com.healthcare_app.billing_service.model.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillRepository extends JpaRepository<Bill , Long> {
}
