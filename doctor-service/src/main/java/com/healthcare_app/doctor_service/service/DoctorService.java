package com.healthcare_app.doctor_service.service;

import com.healthcare_app.doctor_service.model.Doctor;
import com.healthcare_app.doctor_service.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service class for managing Doctor entities.
 * Provides methods for CRUD operations and business logic.
 * Author: R.A.U.K.WIJESEKARA
 */
@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    /**
     * Retrieve all doctors from the database.
     * @return List of all doctors.
     */
    public List<Doctor> getAllDoctors(){
        return doctorRepository.findAll();
    }

    /**
     * Retrieve a doctor by its ID.
     * @param id The ID of the doctor to retrieve.
     * @return An Optional containing the doctor if found, or empty if not found.
     */
    public Optional<Doctor> getDoctorById(Long id){
        return doctorRepository.findById(id);
    }

    /**
     * Save a new doctor to the database.
     * @param doctor The doctor entity to save.
     * @return A success message.
     */
    public String saveDoctor(Doctor doctor){
        doctorRepository.save(doctor);
        return "Doctor saved successfully";
    }

    /**
     * Update an existing doctor's details in the database.
     * @param id The ID of the doctor to update.
     * @param doctorDetails The updated doctor details.
     * @return A success or failure message.
     */
    public String updateDoctor(Long id,Doctor doctorDetails){
        Optional<Doctor> optionalDoctor=doctorRepository.findById(id);
        if (optionalDoctor.isPresent()){
            Doctor doctor = optionalDoctor.get();
            doctor.setFirstName(doctorDetails.getFirstName());
            doctor.setLastName(doctorDetails.getLastName());
            doctor.setSpecialization(doctorDetails.getSpecialization());
            doctor.setContactInformation(doctorDetails.getContactInformation());
            doctorRepository.save(doctor);
            return "Doctor details updated successfully";
        } else {
            return "Doctor details are not found";
        }
    }

    /**
     * Delete a doctor from the database.
     * @param id The ID of the doctor to delete.
     * @return A success or failure message.
     */
    public String deleteDoctor(Long id){
        if (doctorRepository.existsById(id)){
            doctorRepository.deleteById(id);
            return "Doctor information deleted";
        } else {
            return "Doctor details are not found";
        }
    }

}
