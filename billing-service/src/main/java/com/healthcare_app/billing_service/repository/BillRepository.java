package com.healthcare_app.billing_service.repository;


// Declares the package name as com.healthcare_app.billing_service.repository.
// This helps organize the classes in a structured manner and avoids naming conflicts.
import com.healthcare_app.billing_service.model.Bill;

// Imports the Bill class from the com.healthcare_app.billing_service.model package.
// The Bill class is likely a JPA entity representing a table in the database.

import org.springframework.data.jpa.repository.JpaRepository;
// Imports the JpaRepository interface from the Spring Data JPA framework.
// This interface provides JPA-related methods for CRUD operations and more.



public interface BillRepository extends JpaRepository<Bill , Long> {
    // Declares the BillRepository interface which extends JpaRepository.
    // JpaRepository is a generic interface that requires two type parameters:
    // 1. The entity class (Bill) that this repository will manage.
    // 2. The type of the primary key (Long) for the Bill entity.
    // By extending JpaRepository, BillRepository inherits methods for
    // basic CRUD operations (such as save, findById, findAll, deleteById)
    // and additional JPA-specific functionality.


}
