import React from "react";
import {Link} from "react-router-dom";
import 'bootstrap/dist/css/bootstrap.min.css'
import './SideBar.css'

function SideBar() {
    return(
        <div className="d-flex flex-column flex-shrink-0 p-3 bg-light" style={{ width: '250px', height: '100vh' }}>
            <ul className="nav nav-pills flex-column mb-auto">
                {/* Doctor Section */}
                <li className="nav-item">
                    <a className="nav-link active" data-bs-toggle="collapse" href="#doctorSubMenu" role="button" aria-expanded="false" aria-controls="doctorSubMenu">
                        Doctor
                    </a>
                    <div className="collapse" id="doctorSubMenu">
                        <ul className="btn-toggle-nav list-unstyled fw-normal pb-1 small">
                            <li><Link to="/create-doctor" className="nav-link">Create Doctor</Link></li>
                            <li><Link to="/show-doctors" className="nav-link">Show All Doctors</Link></li>
                        </ul>
                    </div>
                </li>

                {/* Patient Section */}
                <li className="nav-item">
                    <a className="nav-link" data-bs-toggle="collapse" href="#patientSubMenu" role="button" aria-expanded="false" aria-controls="patientSubMenu">
                        Patient
                    </a>
                    <div className="collapse" id="patientSubMenu">
                        <ul className="btn-toggle-nav list-unstyled fw-normal pb-1 small">
                            <li><Link to="/show-patient" className="nav-link">Show Patient</Link></li>
                            <li><Link to="/another-details" className="nav-link">Another Details</Link></li>
                        </ul>
                    </div>
                </li>

                {/* Appointment Section */}
                <li className="nav-item">
                    <a className="nav-link" data-bs-toggle="collapse" href="#appointmentSubMenu" role="button" aria-expanded="false" aria-controls="appointmentSubMenu">
                        Appointment
                    </a>
                    <div className="collapse" id="appointmentSubMenu">
                        <ul className="btn-toggle-nav list-unstyled fw-normal pb-1 small">
                            <li><Link to="/appointment-details" className="nav-link">Appointment Details</Link></li>
                        </ul>
                    </div>
                </li>

                {/* Bill Section */}
                <li className="nav-item">
                    <a className="nav-link" data-bs-toggle="collapse" href="#billSubMenu" role="button" aria-expanded="false" aria-controls="billSubMenu">
                        Bill
                    </a>
                    <div className="collapse" id="billSubMenu">
                        <ul className="btn-toggle-nav list-unstyled fw-normal pb-1 small">
                            <li><Link to="/open-bill" className="nav-link">Open Bill</Link></li>
                            <li><Link to="/not-paid-bill" className="nav-link">Not Paid Bill</Link></li>
                            <li><Link to="/all-bills" className="nav-link">All Bills</Link></li>
                        </ul>
                    </div>
                </li>

                {/* Medical Records Section */}
                <li className="nav-item">
                    <a className="nav-link" data-bs-toggle="collapse" href="#medicalRecordsSubMenu" role="button" aria-expanded="false" aria-controls="medicalRecordsSubMenu">
                        Medical Records
                    </a>
                    <div className="collapse" id="medicalRecordsSubMenu">
                        <ul className="btn-toggle-nav list-unstyled fw-normal pb-1 small">
                            <li><Link to="/all-medical-records" className="nav-link">All Medical Records</Link></li>
                        </ul>
                    </div>
                </li>
            </ul>
        </div>
    );
}

export default SideBar;