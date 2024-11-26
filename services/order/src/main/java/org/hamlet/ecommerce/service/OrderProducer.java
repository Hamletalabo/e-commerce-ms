package org.hamlet.ecommerce.service;

import org.hamlet.ecommerce.payload.request.OrderConfirmationRequest;

public interface OrderProducer {
    void sendOrderConfirmation(OrderConfirmationRequest orderConfirmationRequest);
}
