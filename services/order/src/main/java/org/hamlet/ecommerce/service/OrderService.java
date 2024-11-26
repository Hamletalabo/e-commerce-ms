package org.hamlet.ecommerce.service;

import org.hamlet.ecommerce.payload.request.OrderRequest;
import org.hamlet.ecommerce.payload.response.OrderResponse;

import java.util.List;

public interface OrderService {
    Integer createOrder(OrderRequest request);

    List<OrderResponse> findAll();

    OrderResponse findById(Integer orderId);
}
