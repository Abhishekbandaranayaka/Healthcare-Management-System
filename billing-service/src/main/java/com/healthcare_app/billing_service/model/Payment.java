package com.healthcare_app.billing_service.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents a payment entity in the healthcare management system.
 * This entity is mapped to the "payment_table" database table.
 * Uses JPA annotations for ORM and Jakarta Bean Validation annotations for input validation.
 *  * Author: A.A.M.C Abesinghe
 *  * Date: 2024/08/08
 */


@Entity// Marks this class as a JPA entity, meaning it will be mapped to a database table
@Table(name = "payments") // Specifies the name of the table to map this entity to
@Data//  to generate boilerplate code (getters, setters, toString, equals, hashCode)
@AllArgsConstructor //  to generate a constructor with all fields as parameters
@NoArgsConstructor //  to generate a no-argument constructor
public class Payment {
    @Id // Specifies the primary key of the entity
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Configures the way the primary key is generated
    private Long paymentId;

    @ManyToOne // Specifies a many-to-one relationship with the Bill entity
    @JoinColumn(name = "bill_id", nullable = false) // Defines the foreign key column and makes it non-nullable
    @JsonBackReference // Handles the serialization of the Bill reference to avoid circular references
    private Bill bill;

    @NotNull(message = "Amount is mandatory") // Validates that amount cannot be null
    private Double amount;

    @NotNull(message = "Payment date is mandatory")
    private String paymentDate;
 }
