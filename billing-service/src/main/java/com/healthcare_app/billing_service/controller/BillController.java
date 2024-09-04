package com.healthcare_app.billing_service.controller;

import com.healthcare_app.billing_service.exceptions.AppException;
import com.healthcare_app.billing_service.model.Bill;
import com.healthcare_app.billing_service.model.Payment;
import com.healthcare_app.billing_service.service.BillService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing bills and payments.
 * Provides endpoints for CRUD operations.
 *  * Author: A.A.M.C Abesinghe
 *  * Date: 2024/09/02
 */



@RestController
@RequestMapping("/api/billing")
public class BillController {

    @Autowired
    private BillService billService;

    /**
     * Handles application-specific exceptions.
     *
     * @param ex The AppException thrown by the application.
     * @return A ResponseEntity with the error message and status code.
     */


    @ExceptionHandler(AppException.class)
    public ResponseEntity<String> handleAppException(AppException ex) {
        return ResponseEntity.status(ex.getCode()).body(ex.getMessage());
    }
    /**
     * Creates a new bill.
     *
     * @param bill The Bill object to be created.
     * @return A ResponseEntity containing the created Bill object.
     */


    @PostMapping("/create")
    public ResponseEntity<Bill> createBill(@Valid @RequestBody Bill bill){
        Bill createdBill = billService.createBill(bill);
        return ResponseEntity.ok(createdBill);
    }
    /**
     * Processes a payment.
     *
     * @param payment The Payment object to be processed.
     * @return A ResponseEntity containing the processed Payment object.
     */


    @PostMapping("/process_payment")
    public ResponseEntity<Payment> processPayment(@RequestBody Payment payment) {
        Payment processedPayment = billService.processPayment(payment);
        return ResponseEntity.ok(processedPayment);

    }




    /**
     * Retrieves billing details for a specific bill by ID.
     *
     * @param id The ID of the bill to retrieve.
     * @return A ResponseEntity containing the Bill object if found, or a 404 status with an error message if not found.
     */


    @GetMapping("/{id}")

    public ResponseEntity<?> getBillingDetails(@PathVariable Long id) {
        Optional<Bill> bill = billService.getBillingDetails(id);
        if (bill.isPresent()) {
            return ResponseEntity.ok(bill.get());
        } else {
            return ResponseEntity.status(404).body("Bill not found");
        }
    }
    /**
     * Lists all bills.
     *
     * @return A ResponseEntity containing a list of all Bill objects.
     */

    @GetMapping("/bills")
    public ResponseEntity<List<Bill>> listBills() {
        List<Bill> bills = billService.listBills();
        return ResponseEntity.ok(bills);
    }
}
