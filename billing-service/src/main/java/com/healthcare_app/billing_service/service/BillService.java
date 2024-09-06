package com.healthcare_app.billing_service.service;

import com.healthcare_app.billing_service.model.Bill;
import com.healthcare_app.billing_service.model.Payment;

import java.util.List;
import java.util.Optional;

public interface BillService {
    Bill createBill(Bill bill);
    Payment processPayment(Payment payment);
    Optional<Bill> getBillingDetails(Long id);
    List<Bill> listBills();
    List<Bill> findByStatus(String status);

}
