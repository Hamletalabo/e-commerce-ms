package org.hamlet.ecommerce.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hamlet.ecommerce.payload.request.PaymentNotificationRequest;
import org.hamlet.ecommerce.service.NotificationProducer;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import static org.springframework.kafka.support.KafkaHeaders.TOPIC;

@Service
@RequiredArgsConstructor
@Slf4j
public class NotificationProducerImpl implements NotificationProducer {

    private final KafkaTemplate<String, PaymentNotificationRequest> kafkaTemplate;

    @Override
    public void sendNotification(PaymentNotificationRequest paymentNotification) {
        log.info("Sending notification with <{}>", paymentNotification);
        Message<PaymentNotificationRequest> message = MessageBuilder
                .withPayload(paymentNotification)
                .setHeader(TOPIC, "payment-topic")
                .build();
        kafkaTemplate.send(message);
    }
}
