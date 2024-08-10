package com.healthcare_app.billing_service.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Represents a bill entity in the healthcare management system.
 * This entity is mapped to the "Bill_table" database table.
 * Uses JPA annotations for ORM and Jakarta Bean Validation annotations for input validation.
 *  * Author: A.A.M.C Abesinghe
 *  * Date: 2024/08/08
 */



@Entity // Indicates that this class is an entity and will be mapped to a database table
@Table(name = "bills") // Specifies the name of the database table to be used for mapping
@Data // Generates getters, setters, toString, equals, and hashCode methods
@AllArgsConstructor // Generates a constructor with all fields as parameters
@NoArgsConstructor //lombok annotations to Generates a no-argument constructor
public class Bill {
    @Id// Specifies the primary key of the entity
    @GeneratedValue(strategy = GenerationType.IDENTITY)// Configures the way the primary key is generated
    private Long id;

    @NotNull(message = "Patient ID is mandatory")// Validates that patientId cannot be null
    private Long patientId;

    @NotNull(message = "Amount is mandatory")// Validates that amount cannot be null
    private Double amount;

    @NotNull(message = "Status is mandatory")// Validates that status cannot be null
    private String status;

    @OneToMany(mappedBy = "bill", cascade = CascadeType.ALL, orphanRemoval = true)// Configures a one-to-many relationship with Payment entities
    @JsonManagedReference// Handles the serialization of the Payment list to avoid circular references
    private List<Payment> payments;// List to hold associated Payment entities
}
