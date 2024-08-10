package com.healthcare_app.billing_service.service;
// Declares the package name as com.healthcare_app.billing_service.service.
// This helps organize the classes in a structured manner and avoids naming conflicts.
import com.healthcare_app.billing_service.model.Bill;
import com.healthcare_app.billing_service.model.Payment;
import com.healthcare_app.billing_service.repository.BillRepository;
import com.healthcare_app.billing_service.repository.PaymentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
// Imports the necessary classes and interfaces that will be used within the service class.
// These include the Bill and Payment entities, repositories for accessing data,
// transaction management, and annotations for dependency injection and service declaration.
@Service
public class BillService {
    // Marks this class as a service component in Spring's context, enabling it
    // to be automatically detected and managed by the Spring framework.
    @Autowired
    private BillRepository billRepository;
    // Injects an instance of BillRepository using Spring's dependency injection.
    // This allows access to the database for Bill entities.
    @Autowired
    private PaymentRepository paymentRepository;

    // Injects an instance of PaymentRepository using Spring's dependency injection.
    // This allows access to the database for Payment entities
    @Transactional
    public Bill createBill(Bill bill){
        // Marks this method as transactional, meaning all operations within this method
        // will be executed in a single transaction. If any operation fails, the transaction
        // will be rolled back.


        return billRepository.save(bill);
        // Saves the Bill entity to the database using the BillRepository and returns the saved entity.

    }

    @Transactional
    public Payment processPayment(Payment payment)
    // Marks this method as transactional to ensure the entire payment process
    // is completed successfully or rolled back in case of any errors.

    {
        Bill bill = billRepository.findById(payment.getBill().getId())
                .orElseThrow(() -> new RuntimeException("Bill not found"));
// Retrieves the Bill associated with the Payment using the bill ID.
        // If the Bill is not found, throws a RuntimeException with a "Bill not found" message.

        Double billAmount = bill.getAmount();
        Double paymentAmount = payment.getAmount();
        // Gets the bill amount and the payment amount from the Bill and Payment entities.

        if (paymentAmount >= billAmount) // Checks if the payment amount is greater than or equal to the bill amount.
        {
            bill.setStatus("PAID");
            billRepository.save(bill);
            // If the payment covers or exceeds the bill amount, sets the bill status to "PAID"
            // and saves the updated bill to the database


            // Calculate and log the balance if payment is greater than or equal to bill amount
            if (paymentAmount > billAmount) {
                Double balance = paymentAmount - billAmount;
                System.out.println("Payment successful. Balance: " + balance);
                // If the payment amount exceeds the bill amount, calculates the balance
                // and logs it as part of the payment success message.

            } else {
                // If the payment amount is less than the bill amount, the following steps are taken:

                System.out.println("Payment successful. No balance.");
                // If the payment amount exactly matches the bill amount, logs a payment success message
                // indicating there is no balance.
            }
        } else {
            // Calculate remaining amount to be paid
            Double remainingAmount = billAmount - paymentAmount;
            // Calculates the remaining amount that still needs to be paid.

            // Update bill status to reflect partial payment
            if (remainingAmount > 0) {
                bill.setStatus("PARTIALLY PAID");
                // If there is still an amount remaining, sets the bill status to "PARTIALLY PAID".

            }

            billRepository.save(bill);
            System.out.println("Partial payment recorded. Remaining amount: " + remainingAmount);
            // Saves the updated bill with the new status and logs the partial payment and remaining amount.

        }

        // Save payment details
        payment.setBill(bill);
        paymentRepository.save(payment);
        // Associates the payment with the bill and saves the payment details to the database.

        return payment;
        // Returns the saved Payment entity.
    }


    public Optional<Bill> getBillingDetails(Long id){
        return billRepository.findById(id);
        // Retrieves the Bill entity by its ID using the BillRepository and returns it
        // wrapped in an Optional to handle potential null values.
    }

    public List<Bill> listBills() {
        return billRepository.findAll();// Retrieves all Bill entities from the database and returns them as a list.
    }
}
