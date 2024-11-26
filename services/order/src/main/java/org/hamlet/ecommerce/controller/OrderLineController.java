package org.hamlet.ecommerce.controller;

import lombok.RequiredArgsConstructor;
import org.hamlet.ecommerce.entity.OrderLine;
import org.hamlet.ecommerce.payload.response.OrderLineResponse;
import org.hamlet.ecommerce.service.OrderLineService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/order-lines")
public class OrderLineController {

    private final OrderLineService service;

    @GetMapping("/order/{order-id}")
    public ResponseEntity<List<OrderLineResponse>> findByOrderId(@PathVariable ("order-id") Integer orderId){
        return ResponseEntity.ok(service.findAllByOrderId(orderId));
    }
}
