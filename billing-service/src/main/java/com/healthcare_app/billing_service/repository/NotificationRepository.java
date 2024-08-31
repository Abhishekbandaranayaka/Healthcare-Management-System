package com.healthcare_app.billing_service.repository;

import com.healthcare_app.billing_service.model.Notification;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NotificationRepository extends MongoRepository<Notification , String> {
}
