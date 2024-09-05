package com.healthcare_app.billing_service.service.Impl;

import com.healthcare_app.billing_service.exceptions.AppException;
import com.healthcare_app.billing_service.model.Bill;
import com.healthcare_app.billing_service.model.Payment;
import com.healthcare_app.billing_service.repository.BillRepository;
import com.healthcare_app.billing_service.repository.PaymentRepository;
import com.healthcare_app.billing_service.service.BillService;
import com.healthcare_app.billing_service.util.BillServiceConstants;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Implementation of the {@link BillService} interface.
 * Provides methods for managing bills and processing payments in the healthcare management system.
 * Uses Spring's {@link Service} annotation to indicate that it's a service component.
 *
 * Author: A.A.M.C Abesinghe
 * Date: 2024/09/02
 */
@Service
public class BillServiceImpl implements BillService {

    @Autowired
    private BillRepository billRepository;

    @Autowired
    private PaymentRepository paymentRepository;

    /**
     * Creates a new bill and saves it to the database.
     *
     * @param bill The bill to be created.
     * @return The created bill with an auto-generated ID.
     */
    @Transactional
    @Override
    public Bill createBill(Bill bill) {
        try {
            return billRepository.save(bill);
        } catch (Exception e) {
            throw new AppException(HttpStatus.INTERNAL_SERVER_ERROR, "Error creating bill: " + e.getMessage());
        }
    }

    /**
     * Processes a payment for a given bill.
     * Updates the status of the bill based on the payment amount (e.g., "PAID" or "PARTIALLY PAID").
     * Saves the payment to the database.
     *
     * @param payment The payment to be processed.
     * @return The processed payment.
     * @throws AppException if the bill associated with the payment is not found.
     */
    @Transactional
    @Override
    public Payment processPayment(Payment payment) {
        Bill bill = billRepository.findById(payment.getBill().getId())
                .orElseThrow(() -> new AppException(HttpStatus.NOT_FOUND, "Bill not found"));

        Double billAmount = bill.getAmount();
        Double paymentAmount = payment.getAmount();

        if (paymentAmount >= billAmount) {
            bill.setStatus("PAID");
            billRepository.save(bill);

            if (paymentAmount > billAmount) {
                Double balance = paymentAmount - billAmount;
                System.out.println("Payment successful. Balance: " + balance);
            } else {
                System.out.println("Payment successful. No balance.");
            }
        } else {
            Double remainingAmount = billAmount - paymentAmount;

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

    /**
     * Retrieves the billing details for a specific bill ID.
     *
     * @param id The ID of the bill.
     * @return An {@link Optional} containing the bill if found, or empty if not found.
     */
    @Override
    public Optional<Bill> getBillingDetails(Long id) {
        try {
            return billRepository.findById(id);
        } catch (Exception e) {
            throw new AppException(HttpStatus.INTERNAL_SERVER_ERROR, "Error retrieving billing details: " + e.getMessage());
        }
    }

    /**
     * Retrieves a list of all bills in the system.
     *
     * @return A list of all bills.
     */
    @Override
    public List<Bill> listBills() {
        try {
            return billRepository.findAll();
        } catch (Exception e) {
            throw new AppException(HttpStatus.INTERNAL_SERVER_ERROR, "Error retrieving bills: " + e.getMessage());
        }
    }

    /**
     * Find bills by status.
     * @param status The status of the bills to search for.
     * @return List of bills with the given status.
     */
    public List<Bill> findByStatus(String status) {
        List<Bill> bills = billRepository.findByStatus(status);
        if (bills.isEmpty()) {
            throw new AppException(HttpStatus.BAD_REQUEST,
                    "Error retrieving bills: No bills found with status " + status);
        }
        return bills;
    }

}
