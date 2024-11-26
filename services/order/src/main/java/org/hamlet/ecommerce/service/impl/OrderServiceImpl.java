package org.hamlet.ecommerce.service.impl;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.hamlet.ecommerce.exception.BusinessException;
import org.hamlet.ecommerce.payload.request.*;
import org.hamlet.ecommerce.payload.response.OrderResponse;
import org.hamlet.ecommerce.repository.OrderLineRepository;
import org.hamlet.ecommerce.repository.OrderRepository;
import org.hamlet.ecommerce.service.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final CustomerClient customerClient;
    private final ProductClient productClient;
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final OrderLineService orderLineService;
    private final OrderProducer orderProducer;
    private final PaymentClient paymentClient;

    @Override
    public Integer createOrder(OrderRequest request) {
        //check the customer using open feign
        var customer = this.customerClient.findCustomerById(request.getCustomerId()).orElseThrow(
                () -> new BusinessException("Cannot create order:: No Customer exists with the provided ID")
        );

        //purchase the product(use the product micro service) using RestTemplate. Note we can also use Open Feign
        var purchasedProducts = this.productClient.purchaseProduct(request.getProducts());
        //persist the order
        var order = this.orderRepository.save(orderMapper.toOrder(request));

        //persist the order line
        for (PurchaseRequest purchaseRequest: request.getProducts()){
            orderLineService.saveOrderLine( new OrderLineRequest(
                    null, order.getId(), purchaseRequest.getProductId(), purchaseRequest.getQuantity()
            ));
        }

        // start payment
        var paymentRequest = new PaymentRequest(
                request.getAmount(),
                request.getPaymentMethod(),
                order.getId(),
                order.getReference(),
                customer
        );
        paymentClient.requestOrderPayment(paymentRequest);



        //send the order confirmation to the notification micro service using kafka.
        orderProducer.sendOrderConfirmation(
                new OrderConfirmationRequest(
                        request.getReference(),
                        request.getAmount(),
                        request.getPaymentMethod(),
                        customer,
                        purchasedProducts

                )
        );

        return order.getId();
    }

    @Override
    public List<OrderResponse> findAll() {
        return orderRepository.findAll().stream()
                .map(orderMapper::fromOrder)
                .collect(Collectors.toList());
    }

    @Override
    public OrderResponse findById(Integer orderId) {
        return orderRepository.findById(orderId)
                .map(orderMapper::fromOrder)
                .orElseThrow(() -> new EntityNotFoundException("No order found with the order id"));
    }
}
