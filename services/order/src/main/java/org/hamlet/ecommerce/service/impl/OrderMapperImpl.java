package org.hamlet.ecommerce.service.impl;

import lombok.RequiredArgsConstructor;
import org.hamlet.ecommerce.entity.Order;
import org.hamlet.ecommerce.payload.request.OrderRequest;
import org.hamlet.ecommerce.payload.response.OrderResponse;
import org.hamlet.ecommerce.service.OrderMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderMapperImpl implements OrderMapper {

    @Override
    public Order toOrder(OrderRequest request) {
        return Order.builder()
                .id(request.getId())
                .customerId(request.getCustomerId())
                .reference(request.getReference())
                .amount(request.getAmount())
                .paymentMethod(request.getPaymentMethod())
                .build();
    }

    @Override
    public OrderResponse fromOrder(Order order) {
        return new OrderResponse(
                order.getId(),
                order.getReference(),
                order.getAmount(),
                order.getPaymentMethod(),
                order.getCustomerId()
        );
    }
}
