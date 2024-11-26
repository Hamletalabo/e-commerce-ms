package org.hamlet.ecommerce.service;

import org.hamlet.ecommerce.entity.OrderLine;
import org.hamlet.ecommerce.payload.request.OrderLineRequest;
import org.hamlet.ecommerce.payload.response.OrderLineResponse;

public interface OrderLineMapper {
    OrderLine toOrderLine(OrderLineRequest orderLineRequest);

    OrderLineResponse toOrderLineResponse(OrderLine orderLine);
}
