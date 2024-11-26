package org.hamlet.ecommerce.repository;

import org.hamlet.ecommerce.entity.Notification;
import org.hamlet.ecommerce.payload.request.PaymentConfirmationRequest;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NotificationRepository extends MongoRepository<Notification, String> {
}
