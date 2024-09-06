package com.healthcare_app.api_gateway.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "doctor_table")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Doctor {

    /**
     * The unique identifier for the doctor.
     * Auto-generated by the database.
     * Mapped to the "doctor_id" column in the database.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "doctor_id")
    private Long id;

    /**
     * The first name of the doctor.
     * Mandatory field with a maximum length of 100 characters.
     * Mapped to the "first_name" column in the database.
     */
    @NotBlank(message = "First name is mandatory")
    @Size(max = 100, message = "First name cannot be longer than 100 characters")
    @Column(name = "first_name")
    private String firstName;

    /**
     * The last name of the doctor.
     * Mandatory field with a maximum length of 100 characters.
     * Mapped to the "last_name" column in the database.
     */
    @NotBlank(message = "Last name is mandatory")
    @Size(max = 100, message = "Last name cannot be longer than 100 characters")
    @Column(name = "last_name")
    private String lastName;

    /**
     * The specialization of the doctor.
     * Mandatory field with a maximum length of 100 characters.
     */
    @NotBlank(message = "Specialization is mandatory")
    @Size(max = 100, message = "Specialization cannot be longer than 100 characters")
    private String specialization;

    /**
     * The contact information for the doctor.
     * Mandatory field with a maximum length of 200 characters.
     * Mapped to the "contact_information" column in the database.
     */
    @NotBlank(message = "Contact information is mandatory")
    @Size(max = 200, message = "Contact information cannot be longer than 200 characters")
    @Column(name = "contact_information")
    private String contactInformation;

}
