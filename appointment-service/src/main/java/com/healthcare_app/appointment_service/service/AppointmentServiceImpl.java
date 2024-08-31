package com.healthcare_app.appointment_service.service;

import com.healthcare_app.appointment_service.model.Appointment;
import com.healthcare_app.appointment_service.repository.AppointmentRepository;
import com.healthcare_app.appointment_service.repository.DoctorRepository;
import com.healthcare_app.appointment_service.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service class for managing Appointment entities.
 * Provides methods for CRUD operations and business logic related to appointments.
 * Author: Ima Herath
 */
@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private DoctorRepository doctorRepository;

    /**
     * Retrieve all appointments from the database.
     * @return List of all appointments.
     */
    public List<Appointment> getAllAppointments(){
        return appointmentRepository.findAll();
    }

    /**
     * Retrieve an appointment by its ID.
     * @param id The ID of the appointment to retrieve.
     * @return An Optional containing the appointment if found, or empty if not found.
     */
    public Optional<Appointment> getAppointmentById(Long id){
        return appointmentRepository.findById(id);
    }

    /**
     * Book a new appointment by saving it to the database.
     * @param appointment The appointment entity to save.
     * @return A success message.
     */
    public String bookAppointment(Appointment appointment) {
        // Check if the patient exists
        if (!patientRepository.existsById(appointment.getPatientId())) {
            throw new IllegalArgumentException("Invalid Patient ID");
        }

        // Check if the doctor exists
        if (!doctorRepository.existsById(appointment.getDoctorId())) {
            throw new IllegalArgumentException("Invalid Doctor ID");
        }

        // Save the appointment if both exist
        appointmentRepository.save(appointment);
        return "Appointment booked successfully";
    }

    /**
     * Cancel an existing appointment by updating its status.
     * @param id The ID of the appointment to cancel.
     * @return A success or failure message.
     */
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

    /**
     * Update an existing appointment with new details.
     * @param id The ID of the appointment to update.
     * @param appointmentDetails The updated appointment details.
     * @return A success or failure message.
     */
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
