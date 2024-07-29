package com.healthcare_app.appointment_service.service;

import com.healthcare_app.appointment_service.model.Appointment;
import com.healthcare_app.appointment_service.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    public List<Appointment> getAllAppointments(){
        return appointmentRepository.findAll();
    }
    public Optional<Appointment> getAppointmentById(Long id){
        return appointmentRepository.findById(id);
    }
    public String bookAppointment(Appointment appointment){
         appointmentRepository.save(appointment);
         return "Appointment booked successfully";
    }
    public String cancelAppointment(Long id){
        Optional<Appointment> optionalAppointment=appointmentRepository.findById(id);
        if (optionalAppointment.isPresent()){
            Appointment appointment=optionalAppointment.get();
            appointment.setStatus("canceled");
            appointmentRepository.save(appointment);
            return "Appointment cancelled successfully";
        } else {
            return "Appointment not found";
        }
    }
    public String updateAppointment(Long id,Appointment appointmentDetails){
        Optional<Appointment> optionalAppointment=appointmentRepository.findById(id);
        if (optionalAppointment.isPresent()){
            Appointment appointment = optionalAppointment.get();
            appointment.setPatientId(appointmentDetails.getPatientId());
            appointment.setDoctorId(appointmentDetails.getDoctorId());
            appointment.setAppointmentDate(appointmentDetails.getAppointmentDate());
            appointment.setStatus(appointmentDetails.getStatus());
            appointmentRepository.save(appointment);
            return "Appointment updated Successfully";
        } else {
            return "Appointment not found";
        }
    }


}
