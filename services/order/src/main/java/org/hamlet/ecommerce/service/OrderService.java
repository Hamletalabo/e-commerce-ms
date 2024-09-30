package org.hamlet.ecommerce.service;

import org.hamlet.ecommerce.payload.request.OrderRequest;

public interface OrderService {

    Integer createOrder (OrderRequest request);
}
