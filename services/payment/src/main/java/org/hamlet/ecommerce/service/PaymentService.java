package org.hamlet.ecommerce.service;

import org.hamlet.ecommerce.payload.request.PaymentRequest;

public interface PaymentService {
    Integer createPayment(PaymentRequest request);
}
