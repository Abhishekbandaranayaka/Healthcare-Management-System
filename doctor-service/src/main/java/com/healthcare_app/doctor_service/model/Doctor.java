package com.healthcare_app.doctor_service.model;

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
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "doctor_id")
    private Long id;

    @NotBlank(message = "First name is mandatory")
    @Size(max = 100, message = "First name cannot be longer than 100 characters")
    @Column(name = "first_name")
    private String firstName;

    @NotBlank(message = "Last name is mandatory")
    @Size(max = 100, message = "Last name cannot be longer than 100 characters")
    @Column(name = "last_name")
    private String lastName;

    @NotBlank(message = "Specialization is mandatory")
    @Size(max = 100, message = "Specialization cannot be longer than 100 characters")
    private String specialization;

    @NotBlank(message = "Contact information is mandatory")
    @Size(max = 200, message = "Contact information cannot be longer than 200 characters")
    @Column(name = "contact_information")
    private String contactInformation;
}
