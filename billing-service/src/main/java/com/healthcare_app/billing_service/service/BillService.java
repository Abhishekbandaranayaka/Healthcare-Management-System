package com.healthcare_app.billing_service.service;

import com.healthcare_app.billing_service.model.Bill;
import com.healthcare_app.billing_service.model.Payment;
import com.healthcare_app.billing_service.repository.BillRepository;
import com.healthcare_app.billing_service.repository.PaymentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BillService {

    @Autowired
    private BillRepository billRepository;

    @Autowired
    private PaymentRepository paymentRepository;

    @Transactional
    public Bill createBill(Bill bill){
        return billRepository.save(bill);
    }

    @Transactional
    public Payment processPayment(Payment payment) {
        Bill bill = billRepository.findById(payment.getBill().getId())
                .orElseThrow(() -> new RuntimeException("Bill not found"));

        Double billAmount = bill.getAmount();
        Double paymentAmount = payment.getAmount();

        if (paymentAmount >= billAmount) {
            bill.setStatus("PAID");
            billRepository.save(bill);

            // Calculate and log the balance if payment is greater than or equal to bill amount
            if (paymentAmount > billAmount) {
                Double balance = paymentAmount - billAmount;
                System.out.println("Payment successful. Balance: " + balance);
            } else {
                System.out.println("Payment successful. No balance.");
            }
        } else {
            // Calculate remaining amount to be paid
            Double remainingAmount = billAmount - paymentAmount;

            // Update bill status to reflect partial payment
            if (remainingAmount > 0) {
                bill.setStatus("PARTIALLY PAID");
            }

            billRepository.save(bill);
            System.out.println("Partial payment recorded. Remaining amount: " + remainingAmount);
        }

        // Save payment details
        payment.setBill(bill);
        paymentRepository.save(payment);

        return payment;
    }


    public Optional<Bill> getBillingDetails(Long id){
        return billRepository.findById(id);
    }

    public List<Bill> listBills() {
        return billRepository.findAll();
    }
}
