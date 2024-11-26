package org.hamlet.ecommerce.service;

import org.hamlet.ecommerce.entity.Payment;
import org.hamlet.ecommerce.payload.request.PaymentRequest;

public interface PaymentMapper {

    Payment toPayment (PaymentRequest request);
}
