package com.healthcare_app.doctor_service.contoller;

import com.healthcare_app.doctor_service.model.Doctor;
import com.healthcare_app.doctor_service.service.DoctorService;
import com.healthcare_app.doctor_service.util.DoctorServiceConstants;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * This controller handles all HTTP requests related to doctor entities.
 * It provides the endpoints required to perform Create, Read, Update, and Delete (CRUD) operations.
 * Author: R.A.U.K.WIJESEKARA
 */

@RestController
@RequestMapping("/api/doctor")
@Validated
@CrossOrigin(origins = "http://localhost:3000") // The frontend URL
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    /**
     //Retrieves a list of all doctors available in the system.
     * @return A list of Doctor objects.
     */
    @GetMapping
    public List<Doctor> getAllDoctors(){
        return doctorService.getAllDoctors();
    }

    /**
     * Get a specific doctor's details based on the given ID.
     * @param id The unique identifier of the doctor.
     * @return ResponseEntity with the doctor if found, or a 400 status if not found.
     */
    @GetMapping("/{id}")
    public ResponseEntity<?> getDoctorById(@PathVariable Long id){
        Optional<Doctor> doctor=doctorService.getDoctorById(id);
        if (doctor.isPresent()){
            return ResponseEntity.ok(doctor);
        } else {
            return ResponseEntity.status(400).body(DoctorServiceConstants.DOCTOR_NOT_FOUND);
        }
    }

    /**
     * Find doctors by name.
     * @param name The name of the doctor to search for.
     * @return ResponseEntity with a list of doctors or a 404 status if not found.
     */
    @GetMapping("/findByName")
    public ResponseEntity<List<Doctor>> findByFirstName(@RequestParam String firstName) {
        List<Doctor> doctors = doctorService.findByFirstName(firstName);
        if (doctors.isEmpty()) {
            return ResponseEntity.status(404).body(null);
        }
        return ResponseEntity.ok(doctors);
    }

    /**
     * Create a new doctor.
     * @param doctor The doctor entity to create.
     * @return ResponseEntity with a success message.
     */
    @PostMapping("/create")
    public ResponseEntity<String> saveDoctor(@Valid @RequestBody Doctor doctor){
        String message = doctorService.saveDoctor(doctor);
        return ResponseEntity.status(201).body(message);
    }

    /**
     * Update an existing doctor.
     * @param id The ID of the doctor to update.
     * @param doctor The updated doctor details.
     * @return ResponseEntity with a success or failure message.
     */
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateDoctor(@PathVariable Long id,@Valid @RequestBody Doctor doctor){
        String message = doctorService.updateDoctor(id, doctor);
        if (message.equals(DoctorServiceConstants.DOCTOR_UPDATED_SUCCESSFULLY)){
            return ResponseEntity.ok(message);
        } else {
            return ResponseEntity.status(404).body(message);
        }
    }

    /**
     * Delete a doctor.
     * @param id The ID of the doctor to delete.
     * @return ResponseEntity with a success or failure message.
     */
    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteDoctor(@PathVariable Long id){
        String message = doctorService.deleteDoctor(id);
        if (message.equals(DoctorServiceConstants.DOCTOR_DELETED_SUCCESSFULLY)){
            return ResponseEntity.ok(message);
        } else {
            return ResponseEntity.status(404).body(message);
        }
    }
    // DoctorController.java
    @GetMapping("/findBySpecialization")
    public ResponseEntity<List<Doctor>> findBySpecialization(@RequestParam String specialization) {
        List<Doctor> doctors = doctorService.findBySpecialization(specialization);
        if (doctors.isEmpty()) {
            return ResponseEntity.status(404).body(null);
        }
        return ResponseEntity.ok(doctors);
    }
}
