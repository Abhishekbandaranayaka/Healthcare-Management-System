package com.healthcare_app.billing_service.controller;

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
 *  * Date: 2024/08/08
 */



@RestController // Marks this class as a REST controller, making it ready for handling HTTP requests
@RequestMapping("/api/billing")// Specifies the base URL path for all endpoints in this controller
public class BillController {

    @Autowired// Injects an instance of BillService automatically
    private BillService billService;

    @PostMapping("/create")// Maps HTTP POST requests to /create endpoint
    public ResponseEntity<Bill> createBill(@Valid @RequestBody Bill bill){
        Bill createdBill = billService.createBill(bill);// Calls service to create a new bill
        return ResponseEntity.ok(createdBill); // Returns the created bill with HTTP 200 status
    }

    @PostMapping("/process_payment")// Maps HTTP POST requests to /process_payment endpoint
    public ResponseEntity<Payment> processPayment(@RequestBody Payment payment) {
        Payment processedPayment = billService.processPayment(payment);// Calls service to process the payment
        return ResponseEntity.ok(processedPayment);// Returns the processed payment with HTTP 200 status

    }
//add doc comments
    @GetMapping("/{id}")// Maps HTTP GET requests to /{id} endpoint to fetch bill details by ID
    public ResponseEntity<?> getBillingDetails(@PathVariable Long id) {
        Optional<Bill> bill = billService.getBillingDetails(id);// Calls service to get billing details by ID
        if (bill.isPresent()) {
            return ResponseEntity.ok(bill.get());// Returns the bill if found with HTTP 200 status
        } else {
            return ResponseEntity.status(404).body("Bill not found"); // Returns 404 status if bill is not found
        }
    }

    @GetMapping("/bills")// Maps HTTP GET requests to /bills endpoint to list all bills
    public ResponseEntity<List<Bill>> listBills() {
        List<Bill> bills = billService.listBills();// Calls service to list all bills
        return ResponseEntity.ok(bills); // Returns the list of bills with HTTP 200 status
    }
}
