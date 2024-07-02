package com.helthcare_management_sytem.patient_service.service;

import com.helthcare_management_sytem.patient_service.model.Patient;
import com.helthcare_management_sytem.patient_service.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public List<Patient> getAllPatients(){
        return patientRepository.findAll();
    }
    public Optional<Patient> getParentById(Long id){
        return patientRepository.findById(id);
    }
    public String savePatient(Patient patient){
        patientRepository.save(patient);
        return "Patient saved successfully";
    }
    public String updatePatient(Long id,Patient patientDetails){
        Optional<Patient> optionalPatient= patientRepository.findById(id);
        if (optionalPatient.isPresent()){
            Patient patient = optionalPatient.get();
            patient.setName(patientDetails.getName());
            patient.setAddress(patientDetails.getAddress());
            patient.setPhonenumber(patientDetails.getPhonenumber());
            patient.setEmail(patientDetails.getEmail());
            patientRepository.save(patient);
            return "Patient update successfully";
        } else {
            return "Patient not found!";
        }
    }
    public String deletePatient(Long id){
        if (patientRepository.existsById(id)){
            patientRepository.deleteById(id);
            return "Patient delete successfully";
        } else {
            return "Patient not found";
        }
    }
}
