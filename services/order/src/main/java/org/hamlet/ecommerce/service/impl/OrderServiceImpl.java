package org.hamlet.ecommerce.service.impl;

import lombok.RequiredArgsConstructor;
import org.hamlet.ecommerce.exception.BusinessException;
import org.hamlet.ecommerce.payload.request.OrderRequest;
import org.hamlet.ecommerce.service.CustomerClient;
import org.hamlet.ecommerce.service.OrderService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final CustomerClient customerClient;
    private final ProductClient productClient;

    @Override
    public Integer createOrder(OrderRequest request) {
        // check the customer
        // use open feign to check the customer
        var customer = this.customerClient.findById(request.getCustomerId())
                .orElseThrow(() -> new BusinessException("Cannot create order:: No customer" +
                        "exists witht the provided ID"));

        //purchase the products --> product micro-services (Using RestTemplate)

        // persist order

        // persist order lines

        // start payment process

        // send the order confirmation --> notification-ms (kafka)
        return ;
    }
}
