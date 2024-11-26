package org.hamlet.ecommerce.service.impl;

import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hamlet.ecommerce.entity.Notification;
import org.hamlet.ecommerce.payload.request.OrderConfirmationRequest;
import org.hamlet.ecommerce.payload.request.PaymentConfirmationRequest;
import org.hamlet.ecommerce.repository.NotificationRepository;
import org.hamlet.ecommerce.service.EmailService;
import org.hamlet.ecommerce.service.NotificationConsumer;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import static org.hamlet.ecommerce.enums.NotificationType.ORDER_CONFIRMATION;
import static org.hamlet.ecommerce.enums.NotificationType.PAYMENT_CONFIRMATION;

@Service
@RequiredArgsConstructor
@Slf4j
public class NotificationConsumerImpl implements NotificationConsumer {

    private final NotificationRepository notificationRepository;
    private final EmailService emailService;

    @Override
    @KafkaListener(topics = "payment-topic")
    public void consumePaymentSuccessNotification(PaymentConfirmationRequest paymentConfirmation) throws MessagingException {
        log.info(String.format("Consuming the message from payment-topic Topic:: %s", paymentConfirmation));
        notificationRepository.save(
                Notification.builder()
                        .notificationType(PAYMENT_CONFIRMATION)
                        .notificationDate(LocalDateTime.now())
                        .paymentConfirmationRequest(paymentConfirmation)
                        .build()
        );

        //send email
        var customerName = paymentConfirmation.getCustomerFirstname() + " " + paymentConfirmation.getCustomerLastname();
        emailService.sendPaymentSuccessEmail(
                paymentConfirmation.getCustomerEmail(),
                customerName,
                paymentConfirmation.getAmount(),
                paymentConfirmation.getOrderReference()
        );

    }

    @Override
    @KafkaListener(topics = "order-topic")
    public void consumePaymentSuccessNotification(OrderConfirmationRequest orderConfirmation) throws MessagingException {

        log.info(String.format("Consuming the message from order-topic Topic:: %s", orderConfirmation));
        notificationRepository.save(
                Notification.builder()
                        .notificationType(ORDER_CONFIRMATION)
                        .notificationDate(LocalDateTime.now())
                        .orderConfirmation(orderConfirmation)
                        .build()
        );

        //send email
        //send email
        var customerName = orderConfirmation.getCustomer().getFirstname() + " " + orderConfirmation.getCustomer().getLastname();
        emailService.sendOrderConfirmationEmai(
                orderConfirmation.getCustomer().getEmail(),
                customerName,
               orderConfirmation.getTotalAmount(),
                orderConfirmation.getOrderReference(),
                orderConfirmation.getProducts()
        );

    }
}
