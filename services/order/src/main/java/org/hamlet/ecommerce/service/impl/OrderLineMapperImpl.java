package org.hamlet.ecommerce.service.impl;

import lombok.RequiredArgsConstructor;
import org.hamlet.ecommerce.entity.Order;
import org.hamlet.ecommerce.entity.OrderLine;
import org.hamlet.ecommerce.payload.request.OrderLineRequest;
import org.hamlet.ecommerce.payload.response.OrderLineResponse;
import org.hamlet.ecommerce.service.OrderLineMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderLineMapperImpl implements OrderLineMapper {

    @Override
    public OrderLine toOrderLine(OrderLineRequest orderLineRequest) {
        return OrderLine.builder()
                .id(orderLineRequest.getId())
                .quantity(orderLineRequest.getQuantity())
                .order(
                        Order.builder()
                        .id(orderLineRequest.getId())
                        .build())
                .productId(orderLineRequest.getProductId())
                .build();
    }

    @Override
    public OrderLineResponse toOrderLineResponse(OrderLine orderLine) {
        return new OrderLineResponse(
                orderLine.getId(),
                orderLine.getQuantity()
        );
    }
}
