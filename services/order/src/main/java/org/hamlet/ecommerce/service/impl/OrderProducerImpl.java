package org.hamlet.ecommerce.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hamlet.ecommerce.payload.request.OrderConfirmationRequest;
import org.hamlet.ecommerce.service.OrderProducer;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderProducerImpl implements OrderProducer {

    private final KafkaTemplate<String, OrderConfirmationRequest> kafkaTemplate;
    @Override
    public void sendOrderConfirmation(OrderConfirmationRequest orderConfirmationRequest) {
        log.info("Sending order confirmation");
        Message<OrderConfirmationRequest> message = MessageBuilder
                .withPayload(orderConfirmationRequest)
                .setHeader(KafkaHeaders.TOPIC, "order-topic")
                .build();
        kafkaTemplate.send(message);
    }
}
