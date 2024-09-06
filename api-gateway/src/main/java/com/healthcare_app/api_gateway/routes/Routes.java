package com.healthcare_app.api_gateway.routes;

import org.springframework.cloud.gateway.server.mvc.handler.GatewayRouterFunctions;
import org.springframework.cloud.gateway.server.mvc.handler.HandlerFunctions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.function.RequestPredicates;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;

/**
 * Configuration class for defining the routes for different services in the healthcare application.
 * Each route maps a specific path and HTTP method to a corresponding service endpoint.
 * Author: B.T.M.A.S.D.B Rathnayaka
 * Date: 2024/07/21
 */

@Configuration
public class Routes {

    /**
     * Define the routes for the Patient Service.
     * @return RouterFunction for the Patient Service routes.
     */
    @Bean
    public RouterFunction<ServerResponse> patientServiceRoute(){
        return GatewayRouterFunctions.route("patient_service")
                // Route for retrieving a list of patients
                .route(RequestPredicates.path("/api/patients").and(RequestPredicates.method(HttpMethod.GET)), HandlerFunctions.http("http://localhost:8080"))
                // Route for retrieving a specific patient by ID
                .route(RequestPredicates.path("/api/patients/{id}").and(RequestPredicates.method(HttpMethod.GET)), HandlerFunctions.http("http://localhost:8080"))
                // Route for creating a new patient
                .route(RequestPredicates.path("/api/patients/create").and(RequestPredicates.method(HttpMethod.POST)), HandlerFunctions.http("http://localhost:8080"))
                // Route for updating an existing patient by ID
                .route(RequestPredicates.path("/api/patients/update/{id}").and(RequestPredicates.method(HttpMethod.PUT)), HandlerFunctions.http("http://localhost:8080"))
                // Route for deleting a patient by ID
                .route(RequestPredicates.path("/api/patients/delete/{id}").and(RequestPredicates.method(HttpMethod.DELETE)), HandlerFunctions.http("http://localhost:8080"))
                .build();
    }

    /**
     * Define the routes for the Doctor Service.
     * @return RouterFunction for the Doctor Service routes.
     */
    @Bean
    public RouterFunction<ServerResponse> doctorServiceRoute(){
        return GatewayRouterFunctions.route("doctor_service")
                // Route for retrieving a list of doctors
                .route(RequestPredicates.path("/api/doctor").and(RequestPredicates.method(HttpMethod.GET)), HandlerFunctions.http("http://localhost:8081"))
                // Route for retrieving a specific doctor by ID
                .route(RequestPredicates.path("/api/doctor/{id}").and(RequestPredicates.method(HttpMethod.GET)), HandlerFunctions.http("http://localhost:8081"))
                // Route for creating a new doctor
                .route(RequestPredicates.path("/api/doctor/create").and(RequestPredicates.method(HttpMethod.POST)), HandlerFunctions.http("http://localhost:8081"))
                // Route for updating an existing doctor by ID
                .route(RequestPredicates.path("/api/doctor/update/{id}").and(RequestPredicates.method(HttpMethod.PUT)), HandlerFunctions.http("http://localhost:8081"))
                // Route for deleting a doctor by ID
                .route(RequestPredicates.path("/api/doctordelete/{id}").and(RequestPredicates.method(HttpMethod.DELETE)), HandlerFunctions.http("http://localhost:8081"))
                .build();
    }

    /**
     * Define the routes for the Appointment Service.
     * @return RouterFunction for the Appointment Service routes.
     */
    @Bean
    public RouterFunction<ServerResponse> appointmentServiceRoute(){
        return GatewayRouterFunctions.route("appointment_service")
                // Route for retrieving a list of appointments
                .route(RequestPredicates.path("/api/appointments").and(RequestPredicates.method(HttpMethod.GET)), HandlerFunctions.http("http://localhost:8082"))
                // Route for retrieving a specific appointment by ID
                .route(RequestPredicates.path("/api/appointments/{id}").and(RequestPredicates.method(HttpMethod.GET)), HandlerFunctions.http("http://localhost:8082"))
                // Route for creating a new appointment
                .route(RequestPredicates.path("/api/appointments/create").and(RequestPredicates.method(HttpMethod.POST)), HandlerFunctions.http("http://localhost:8082"))
                // Route for updating an existing appointment by ID
                .route(RequestPredicates.path("/api/appointments/{id}").and(RequestPredicates.method(HttpMethod.PUT)), HandlerFunctions.http("http://localhost:8082"))
                // Route for updating an appointment (alternative endpoint)
                .route(RequestPredicates.path("/api/appointments/update/{id}").and(RequestPredicates.method(HttpMethod.PUT)), HandlerFunctions.http("http://localhost:8082"))
                .build();
    }

    /**
     * Define the routes for the Medical Records Service.
     * @return RouterFunction for the Medical Records Service routes.
     */
    @Bean
    public RouterFunction<ServerResponse> medicalRecordsServiceRoute(){
        return GatewayRouterFunctions.route("medicalRecord_service")
                // Route for retrieving a list of medical records
                .route(RequestPredicates.path("/api/medical_records").and(RequestPredicates.method(HttpMethod.GET)), HandlerFunctions.http("http://localhost:8083"))
                // Route for retrieving a specific medical record by ID
                .route(RequestPredicates.path("/api/medical_records/{id}").and(RequestPredicates.method(HttpMethod.GET)), HandlerFunctions.http("http://localhost:8083"))
                // Route for creating a new medical record
                .route(RequestPredicates.path("/api/medical_records/create").and(RequestPredicates.method(HttpMethod.POST)), HandlerFunctions.http("http://localhost:8083"))
                // Route for updating an existing medical record by ID
                .route(RequestPredicates.path("/api/medical_records/update/{id}").and(RequestPredicates.method(HttpMethod.PUT)), HandlerFunctions.http("http://localhost:8083"))
                .build();
    }

    /**
     * Define the routes for the Billing Service.
     * @return RouterFunction for the Billing Service routes.
     */
    @Bean
    public RouterFunction<ServerResponse> billingServiceRoute(){
        return GatewayRouterFunctions.route("billing_service")
                // Route for retrieving a list of bills
                .route(RequestPredicates.path("/api/billing/bills").and(RequestPredicates.method(HttpMethod.GET)), HandlerFunctions.http("http://localhost:8084"))
                // Route for retrieving a specific bill by ID
                .route(RequestPredicates.path("/api/billing/{id}").and(RequestPredicates.method(HttpMethod.GET)), HandlerFunctions.http("http://localhost:8084"))
                // Route for creating a new bill
                .route(RequestPredicates.path("/api/billing/create").and(RequestPredicates.method(HttpMethod.POST)), HandlerFunctions.http("http://localhost:8084"))
                // Route for processing a payment
                .route(RequestPredicates.path("/api/billing/process_payment").and(RequestPredicates.method(HttpMethod.POST)), HandlerFunctions.http("http://localhost:8084"))
                .build();
    }

    /**
     * Define the routes for the Notification Service.
     * @return RouterFunction for the Notification Service routes.
     */
    @Bean
    public RouterFunction<ServerResponse> notificationServiceRoute(){
        return GatewayRouterFunctions.route("notification_service")
                // Route for retrieving a list of notifications
                .route(RequestPredicates.path("/api/notifications/list").and(RequestPredicates.method(HttpMethod.GET)), HandlerFunctions.http("http://localhost:8085"))
                // Route for sending a notification
                .route(RequestPredicates.path("/api/notifications/send").and(RequestPredicates.method(HttpMethod.POST)), HandlerFunctions.http("http://localhost:8085"))
                .build();
    }



}
