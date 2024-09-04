package com.healthcare_app.appointment_service.service.Impl;

import com.healthcare_app.appointment_service.exception.AppException;
import com.healthcare_app.appointment_service.model.Appointment;
import com.healthcare_app.appointment_service.model.Doctor;
import com.healthcare_app.appointment_service.model.Patient;
import com.healthcare_app.appointment_service.repository.AppointmentRepository;
import com.healthcare_app.appointment_service.repository.DoctorRepository;
import com.healthcare_app.appointment_service.repository.PatientRepository;
import com.healthcare_app.appointment_service.service.AppointmentService;
import com.healthcare_app.appointment_service.service.NotificationService;
import com.healthcare_app.appointment_service.util.AppointmentServiceConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @Autowired
    private NotificationService notificationService;

    /**
     * Retrieve all appointments from the database.
     * @return List of all appointments.
     */
    @Override
    public List<Appointment> getAllAppointments() {
        List<Appointment> appointments = appointmentRepository.findAll();
        for (Appointment appointment : appointments) {
            Patient patient = patientRepository.findById(appointment.getPatientId()).orElse(null);
            Doctor doctor = doctorRepository.findById(appointment.getDoctorId()).orElse(null);
            if (patient != null) {
                appointment.setPatientName(patient.getName());
            }
            if (doctor != null) {
                appointment.setDoctorName(doctor.getFirstName() + " " + doctor.getLastName());
            }
        }
        return appointments;
    }

    /**
     * Retrieve an appointment by its ID.
     * @param id The ID of the appointment to retrieve.
     * @return An Optional containing the appointment if found, or empty if not found.
     */
    @Override
    public Optional<Appointment> getAppointmentById(Long id) {
        Optional<Appointment> optionalAppointment = appointmentRepository.findById(id);
        if (optionalAppointment.isPresent()) {
            Appointment appointment = optionalAppointment.get();
            Patient patient = patientRepository.findById(appointment.getPatientId()).orElse(null);
            Doctor doctor = doctorRepository.findById(appointment.getDoctorId()).orElse(null);
            if (patient != null) {
                appointment.setPatientName(patient.getName());
            }
            if (doctor != null) {
                appointment.setDoctorName(doctor.getFirstName() + " " + doctor.getLastName());
            }
        }
        return optionalAppointment;
    }

    /**
     * Book a new appointment by saving it to the database.
     * @param appointment The appointment entity to save.
     * @return A success message.
     */
    @Override
    public String bookAppointment(Appointment appointment) {
        // Check if the patient exists
        if (!patientRepository.existsById(appointment.getPatientId())) {
            throw new AppException(AppointmentServiceConstants.INVALID_PATIENT_ID, HttpStatus.BAD_REQUEST);
        }

        // Check if the doctor exists
        if (!doctorRepository.existsById(appointment.getDoctorId())) {
            throw new AppException(AppointmentServiceConstants.INVALID_DOCTOR_ID, HttpStatus.BAD_REQUEST);
        }

        // Save the appointment if both exist
        appointmentRepository.save(appointment);

        String message = AppointmentServiceConstants.APPOINTMENT_CREATED_NOTIFICATION;
        notificationService.createNotification(appointment.getPatientId(), appointment.getDoctorId(), message);

        return AppointmentServiceConstants.APPOINTMENT_BOOKED_SUCCESSFULLY;
    }

    /**
     * Cancel an existing appointment.
     * @param id The ID of the appointment to cancel.
     * @return A success or failure message.
     */
    @Override
    public String cancelAppointment(Long id) {
        Optional<Appointment> optionalAppointment = appointmentRepository.findById(id);
        if (optionalAppointment.isPresent()) {
            Appointment appointment = optionalAppointment.get();
            appointment.setStatus(AppointmentServiceConstants.STATUS_CANCELLED);
            appointmentRepository.save(appointment);

            // Create notification for cancellation
            String message = AppointmentServiceConstants.APPOINTMENT_CANCELLED_NOTIFICATION;
            notificationService.createNotification(appointment.getPatientId(), appointment.getDoctorId(), message);

            return AppointmentServiceConstants.APPOINTMENT_CANCELLED_SUCCESSFULLY;
        } else {
            throw new AppException(AppointmentServiceConstants.APPOINTMENT_NOT_FOUND, HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Update an existing appointment.
     * @param id The ID of the appointment to update.
     * @param appointmentDetails The updated appointment details.
     * @return A success or failure message.
     */
    @Override
    public String updateAppointment(Long id, Appointment appointmentDetails) {
        Optional<Appointment> optionalAppointment = appointmentRepository.findById(id);
        if (optionalAppointment.isPresent()) {
            Appointment appointment = optionalAppointment.get();
            appointment.setPatientId(appointmentDetails.getPatientId());
            appointment.setDoctorId(appointmentDetails.getDoctorId());
            appointment.setAppointmentDate(appointmentDetails.getAppointmentDate());
            appointment.setStatus(appointmentDetails.getStatus());
            appointmentRepository.save(appointment);

            // Create notification for update
            String message = AppointmentServiceConstants.APPOINTMENT_UPDATED_NOTIFICATION;
            notificationService.createNotification(appointment.getPatientId(), appointment.getDoctorId(), message);

            return AppointmentServiceConstants.APPOINTMENT_UPDATED_SUCCESSFULLY;
        } else {
            throw new AppException(AppointmentServiceConstants.APPOINTMENT_NOT_FOUND, HttpStatus.NOT_FOUND);
        }
    }
}
