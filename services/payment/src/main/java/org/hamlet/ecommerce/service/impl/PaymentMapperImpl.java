package org.hamlet.ecommerce.service.impl;

import lombok.RequiredArgsConstructor;
import org.hamlet.ecommerce.entity.Payment;
import org.hamlet.ecommerce.payload.request.PaymentRequest;
import org.hamlet.ecommerce.service.PaymentMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentMapperImpl implements PaymentMapper {
    @Override
    public Payment toPayment(PaymentRequest request) {
        return Payment.builder()
                .id(request.getId())
                .orderId(request.getOrderId())
                .paymentMethod(request.getPaymentMethod())
                .amount(request.getAmount())
                .build();
    }
}
