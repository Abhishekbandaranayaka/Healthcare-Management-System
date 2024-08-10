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

@RestController
@RequestMapping("/api/billing")
public class BillController {

    @Autowired
    private BillService billService;

    @PostMapping("/create")
    public ResponseEntity<Bill> createBill(@Valid @RequestBody Bill bill){
        Bill createdBill = billService.createBill(bill);
        return ResponseEntity.ok(createdBill);
    }

    @PostMapping("/process_payment")
    public ResponseEntity<Payment> processPayment(@RequestBody Payment payment) {
        Payment processedPayment = billService.processPayment(payment);
        return ResponseEntity.ok(processedPayment);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getBillingDetails(@PathVariable Long id) {
        Optional<Bill> bill = billService.getBillingDetails(id);
        if (bill.isPresent()) {
            return ResponseEntity.ok(bill.get());
        } else {
            return ResponseEntity.status(404).body("Bill not found");
        }
    }

    @GetMapping("/bills")
    public ResponseEntity<List<Bill>> listBills() {
        List<Bill> bills = billService.listBills();
        return ResponseEntity.ok(bills);
    }
}
