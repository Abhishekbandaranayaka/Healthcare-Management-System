package com.healthcare_app.doctor_service.contoller;

import com.healthcare_app.doctor_service.model.Doctor;
import com.healthcare_app.doctor_service.service.DoctorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/doctor")
@Validated
@CrossOrigin(origins = "http://localhost:5173") // The frontend URL
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @GetMapping
    public List<Doctor> getAllDoctors(){
        return doctorService.getAllDoctors();
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getDoctorById(@PathVariable Long id){
        Optional<Doctor> doctor=doctorService.getDoctorById(id);
        if (doctor.isPresent()){
            return ResponseEntity.ok(doctor);
        } else {
            return ResponseEntity.status(400).body("Doctor details not found");
        }
    }
    @PostMapping("/create")
    public ResponseEntity<String> saveDoctor(@Valid @RequestBody Doctor doctor){
        String message = doctorService.saveDoctor(doctor);
        return ResponseEntity.status(201).body(message);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateDoctor(@PathVariable Long id,@Valid @RequestBody Doctor doctor){
        String message = doctorService.updateDoctor(id, doctor);
        if (message.equals("Doctor details updated successfully")){
            return ResponseEntity.ok(message);
        } else {
            return ResponseEntity.status(404).body(message);
        }
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteDoctor(@PathVariable Long id){
        String message = doctorService.deleteDoctor(id);
        if (message.equals("Doctor information deleted")){
            return ResponseEntity.ok(message);
        } else {
            return ResponseEntity.status(404).body(message);
        }
    }
}
