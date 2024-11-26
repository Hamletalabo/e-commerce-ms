package org.hamlet.ecommerce.service;

import jakarta.mail.MessagingException;
import org.hamlet.ecommerce.payload.request.OrderConfirmationRequest;
import org.hamlet.ecommerce.payload.request.PaymentConfirmationRequest;

public interface NotificationConsumer {

    void consumePaymentSuccessNotification(PaymentConfirmationRequest paymentConfirmation) throws MessagingException;
    void consumePaymentSuccessNotification(OrderConfirmationRequest orderConfirmation) throws MessagingException;
}
