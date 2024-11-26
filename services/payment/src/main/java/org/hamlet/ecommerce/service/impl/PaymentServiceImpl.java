package org.hamlet.ecommerce.service.impl;

import lombok.RequiredArgsConstructor;
import org.hamlet.ecommerce.payload.request.PaymentNotificationRequest;
import org.hamlet.ecommerce.payload.request.PaymentRequest;
import org.hamlet.ecommerce.repository.PaymentRepository;
import org.hamlet.ecommerce.service.NotificationProducer;
import org.hamlet.ecommerce.service.PaymentService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final NotificationProducer notificationProducer;
    private final PaymentRepository repository;
    private final PaymentMapperImpl paymentMapper;


    @Override
    public Integer createPayment(PaymentRequest request) {
        var payment = repository.save(paymentMapper.toPayment(request));

        //sent notification
        notificationProducer.sendNotification(
                new PaymentNotificationRequest(
                        request.getOrderReference(),
                        request.getAmount(),
                        request.getPaymentMethod(),
                        request.getCustomer().firstname(),
                        request.getCustomer().lastname(),
                        request.getCustomer().email()
                )
        );
        return payment.getId();
    }
}
