package org.hamlet.ecommerce.service;

import org.hamlet.ecommerce.entity.Order;
import org.hamlet.ecommerce.payload.request.OrderRequest;
import org.hamlet.ecommerce.payload.response.OrderResponse;

public interface OrderMapper {
    Order toOrder(OrderRequest request);

    OrderResponse fromOrder(Order order);
}
