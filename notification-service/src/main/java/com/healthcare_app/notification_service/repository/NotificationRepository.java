package com.healthcare_app.notification_service.repository;

import com.healthcare_app.notification_service.model.Notification;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
/**
 * The NotificationRepository interface provides CRUD operations for Notification entities in the MongoDB database.
 * It extends the MongoRepository interface, which provides methods such as save, findAll, findById, and delete.
 * * Author: S.T Fernando
 * *Date: 2024/07/29
 */
@Repository
public interface NotificationRepository extends MongoRepository<Notification , String> {
}
