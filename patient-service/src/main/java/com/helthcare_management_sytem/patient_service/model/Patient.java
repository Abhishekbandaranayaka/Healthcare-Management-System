package com.helthcare_management_sytem.patient_service.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "patients_table")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is mandatory")
    @Size(max = 100, message = "Name cannot be longer than 100 characters")
    private String name;

    @NotBlank(message = "Address is mandatory")
    @Size(max = 200, message = "Address cannot be longer than 200 characters")
    private String address;

    @NotBlank(message = "Phone number is mandatory")
    @Size(max = 15, message = "Phone number cannot be longer than 15 characters")
    private String phonenumber;

    private String email;

}
