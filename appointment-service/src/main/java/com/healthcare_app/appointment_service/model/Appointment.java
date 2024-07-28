package com.healthcare_app.appointment_service.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "appointment_table")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Patient ID is mandatory")
    @Column(name = "patient_id")
    private Long patientId;

    @NotNull(message = "Doctor ID is mandatory")
    @Column(name = "doctor_id")
    private Long doctorId;

    @NotNull(message = "Appointment date is mandatory")
    @Future(message = "Appointment date must be in the future")
    @Column(name = "appointment_date")
    private LocalDateTime appointmentDate;

    @NotNull(message = "Status is mandatory")
    private String status;
}
