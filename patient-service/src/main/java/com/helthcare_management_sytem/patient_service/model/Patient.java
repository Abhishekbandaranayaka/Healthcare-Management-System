package com.helthcare_management_sytem.patient_service.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents a patient entity in the healthcare management system.
 * This entity is mapped to the "patients_table" database table.
 * Uses JPA annotations for ORM and Jakarta Bean Validation annotations for input validation.
 *  * Author: B.T.M.A.S.D.B Rathnayaka
 *  * Date: 2024/07/01
 */
@Entity
@Table(name = "patients_table")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Patient {

    /**
     * The unique identifier for the patient.
     * Auto-generated by the database.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * The name of the patient.
     * Mandatory field with a maximum length of 100 characters.
     */
    @NotBlank(message = "Name is mandatory")
    @Size(max = 100, message = "Name cannot be longer than 100 characters")
    private String name;

    /**
     * The address of the patient.
     * Mandatory field with a maximum length of 200 characters.
     */
    @NotBlank(message = "Address is mandatory")
    @Size(max = 200, message = "Address cannot be longer than 200 characters")
    private String address;

    /**
     * The phone number of the patient.
     * Mandatory field with a maximum length of 15 characters.
     */
    @NotBlank(message = "Phone number is mandatory")
    @Size(max = 15, message = "Phone number cannot be longer than 15 characters")
    private String phoneNumber;

    /**
     * The email address of the patient.
     * Optional field.
     */
    private String email;

}
