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
                .route(RequestPredicates.path("/api/patients").and(RequestPredicates.method(HttpMethod.GET)), HandlerFunctions.http("http://localhost:8080"))
                .route(RequestPredicates.path("/api/patients/{id}").and(RequestPredicates.method(HttpMethod.GET)), HandlerFunctions.http("http://localhost:8080"))
                .route(RequestPredicates.path("/api/patients/create").and(RequestPredicates.method(HttpMethod.POST)), HandlerFunctions.http("http://localhost:8080"))
                .route(RequestPredicates.path("/api/patients/update/{id}").and(RequestPredicates.method(HttpMethod.PUT)), HandlerFunctions.http("http://localhost:8080"))
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
                .route(RequestPredicates.path("/api/doctor").and(RequestPredicates.method(HttpMethod.GET)), HandlerFunctions.http("http://localhost:8081"))
                .route(RequestPredicates.path("/api/doctor/{id}").and(RequestPredicates.method(HttpMethod.GET)), HandlerFunctions.http("http://localhost:8081"))
                .route(RequestPredicates.path("/api/doctor/create").and(RequestPredicates.method(HttpMethod.POST)), HandlerFunctions.http("http://localhost:8081"))
                .route(RequestPredicates.path("/api/doctor/update/{id}").and(RequestPredicates.method(HttpMethod.PUT)), HandlerFunctions.http("http://localhost:8081"))
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
                .route(RequestPredicates.path("/api/appointments").and(RequestPredicates.method(HttpMethod.GET)), HandlerFunctions.http("http://localhost:8082"))
                .route(RequestPredicates.path("/api/appointments/{id}").and(RequestPredicates.method(HttpMethod.GET)), HandlerFunctions.http("http://localhost:8082"))
                .route(RequestPredicates.path("/api/appointments/create").and(RequestPredicates.method(HttpMethod.POST)), HandlerFunctions.http("http://localhost:8082"))
                .route(RequestPredicates.path("/api/appointments/{id}").and(RequestPredicates.method(HttpMethod.PUT)), HandlerFunctions.http("http://localhost:8082"))
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
                .route(RequestPredicates.path("/api/medical_records").and(RequestPredicates.method(HttpMethod.GET)), HandlerFunctions.http("http://localhost:8083"))
                .route(RequestPredicates.path("/api/medical_records/{id}").and(RequestPredicates.method(HttpMethod.GET)), HandlerFunctions.http("http://localhost:8083"))
                .route(RequestPredicates.path("/api/medical_records/create").and(RequestPredicates.method(HttpMethod.POST)), HandlerFunctions.http("http://localhost:8083"))
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
                .route(RequestPredicates.path("/api/billing/bills").and(RequestPredicates.method(HttpMethod.GET)), HandlerFunctions.http("http://localhost:8084"))
                .route(RequestPredicates.path("/api/billing/{id}").and(RequestPredicates.method(HttpMethod.GET)), HandlerFunctions.http("http://localhost:8084"))
                .route(RequestPredicates.path("/api/billing/create").and(RequestPredicates.method(HttpMethod.POST)), HandlerFunctions.http("http://localhost:8084"))
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
                .route(RequestPredicates.path("/api/notifications/list").and(RequestPredicates.method(HttpMethod.GET)), HandlerFunctions.http("http://localhost:8085"))
                .route(RequestPredicates.path("/api/notifications/send").and(RequestPredicates.method(HttpMethod.POST)), HandlerFunctions.http("http://localhost:8085"))
                .build();
    }



}
