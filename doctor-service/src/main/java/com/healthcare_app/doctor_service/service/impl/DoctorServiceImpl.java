package com.healthcare_app.doctor_service.service.impl;

import com.healthcare_app.doctor_service.exception.AppException;
import com.healthcare_app.doctor_service.model.Doctor;
import com.healthcare_app.doctor_service.repository.DoctorRepository;
import com.healthcare_app.doctor_service.service.DoctorService;
import com.healthcare_app.doctor_service.util.DoctorServiceConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service class for managing Doctor entities.
 * Provides methods for CRUD operations and business logic.
 * Author: R.A.U.K.WIJESEKARA
 */
@Service
public class DoctorServiceImpl implements DoctorService {
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
        try {
            doctorRepository.save(doctor);
            return DoctorServiceConstants.DOCTOR_SAVED_SUCCESSFULLY;
        }catch (Exception e){
            throw new AppException("Error Saving Doctor", HttpStatus.INTERNAL_SERVER_ERROR);
        }
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
            return DoctorServiceConstants.DOCTOR_UPDATED_SUCCESSFULLY;
        } else {
            throw new AppException(DoctorServiceConstants.DOCTOR_NOT_FOUND,HttpStatus.NOT_FOUND);
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
            return DoctorServiceConstants.DOCTOR_DELETED_SUCCESSFULLY;
        } else {
            throw new AppException(DoctorServiceConstants.DOCTOR_NOT_FOUND,HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Find doctors by name.
     * @param name The name of the doctor to search for.
     * @return List of doctors with the given name.
     */
    public List<Doctor> findByFirstName(String firstName) {
        List<Doctor> doctors = doctorRepository.findByFirstName(firstName);
        if (doctors.isEmpty()) {
            throw new AppException(DoctorServiceConstants.DOCTOR_NOT_FOUND, HttpStatus.NOT_FOUND);
        }
        return doctors;
    }


    public List<Doctor> findBySpecialization(String specialization) {
        return doctorRepository.findBySpecialization(specialization);
    }

}
