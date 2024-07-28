package com.healthcare_app.medicalrecords_service.model;

import org.springframework.data.annotation.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * This class represents the medical records in the healthcare application.
 * It is a MongoDB document that stores information about a patient's medical records.
 */
@Document(collection = "medical_records")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedicalRecords {

    // Unique identifier for the medical record
    @Id
    private String recordId;

    // Patient ID is a mandatory field and maps to the "patient_id" field in the database
    @NotNull(message = "Patient ID is mandatory")
    @Field("patient_id")
    private Long patientId;

    // Medical history is a mandatory field and maps to the "medical_history" field in the database
    @NotBlank(message = "Medical history is mandatory")
    @Field("medical_history")
    private String medicalHistory;

    // Diagnosis is a mandatory field
    @NotBlank(message = "Diagnosis is mandatory")
    private String diagnosis;

    // Treatments are mandatory
    @NotBlank(message = "Treatments are mandatory")
    private String treatments;
}
