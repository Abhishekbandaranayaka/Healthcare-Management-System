package com.healthcare_app.billing_service.repository;
// Declares the package name as com.healthcare_app.billing_service.repository.
// This helps organize the classes in a structured manner and avoids naming conflicts.
import com.healthcare_app.billing_service.model.Payment;
// Imports the Payment class from the com.healthcare_app.billing_service.model package.
// The Payment class is likely a JPA entity representing a table in the database.
import org.springframework.data.jpa.repository.JpaRepository;
// Imports the JpaRepository interface from the Spring Data JPA framework.
// This interface provides JPA-related methods for CRUD operations and more.

public interface PaymentRepository extends JpaRepository<Payment , Long> {
    // Declares the PaymentRepository interface which extends JpaRepository.
    // JpaRepository is a generic interface that requires two type parameters:
    // 1. The entity class (Payment) that this repository will manage.
    // 2. The type of the primary key (Long) for the Payment entity.
    // By extending JpaRepository, PaymentRepository inherits methods for
    // basic CRUD operations (such as save, findById, findAll, deleteById)
    // and additional JPA-specific functionality.


}
