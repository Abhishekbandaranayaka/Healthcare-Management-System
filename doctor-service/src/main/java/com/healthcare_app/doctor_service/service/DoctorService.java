package com.healthcare_app.doctor_service.service;

import com.healthcare_app.doctor_service.model.Doctor;
import com.healthcare_app.doctor_service.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    public List<Doctor> getAllDoctors(){
        return doctorRepository.findAll();
    }
    public Optional<Doctor> getDoctorById(Long id){
        return doctorRepository.findById(id);
    }
    public String saveDoctor(Doctor doctor){
        doctorRepository.save(doctor);
        return "Doctor saved successfully";
    }
    public String updateDoctor(Long id,Doctor doctorDetails){
        Optional<Doctor> optionalDoctor=doctorRepository.findById(id);
        if (optionalDoctor.isPresent()){
            Doctor doctor = optionalDoctor.get();
            doctor.setFirstName(doctorDetails.getFirstName());
            doctor.setLastName(doctorDetails.getLastName());
            doctor.setSpecialization(doctorDetails.getSpecialization());
            doctor.setContactInformation(doctorDetails.getContactInformation());
            return "Doctor details updated successfully";
        } else {
            return "Doctor details are not found";
        }
    }
    public String deleteDoctor(Long id){
        if (doctorRepository.existsById(id)){
            doctorRepository.deleteById(id);
            return "Doctor information deleted";
        } else {
            return "Doctor details are not found";
        }
    }

}
