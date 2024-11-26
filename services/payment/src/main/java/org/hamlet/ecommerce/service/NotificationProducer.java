package org.hamlet.ecommerce.service;

import org.hamlet.ecommerce.payload.request.PaymentNotificationRequest;

public interface NotificationProducer {
    void sendNotification(PaymentNotificationRequest request);
}
