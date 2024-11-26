package org.hamlet.ecommerce.service;

import org.hamlet.ecommerce.payload.request.OrderLineRequest;
import org.hamlet.ecommerce.payload.response.OrderLineResponse;

import java.util.List;

public interface OrderLineService {
    Integer saveOrderLine(OrderLineRequest orderLineRequest);

    List<OrderLineResponse> findAllByOrderId(Integer orderId);
}
