package org.hamlet.ecommerce.service.impl;

import lombok.RequiredArgsConstructor;
import org.hamlet.ecommerce.payload.request.OrderLineRequest;
import org.hamlet.ecommerce.payload.response.OrderLineResponse;
import org.hamlet.ecommerce.repository.OrderLineRepository;
import org.hamlet.ecommerce.service.OrderLineMapper;
import org.hamlet.ecommerce.service.OrderLineService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderLineServiceImpl implements OrderLineService {

    private final OrderLineRepository orderLineRepository;

    private final OrderLineMapper orderLineMapper;

    @Override
    public Integer saveOrderLine(OrderLineRequest orderLineRequest) {
        var order = orderLineMapper.toOrderLine(orderLineRequest);
        return orderLineRepository.save(order).getId();
    }

    @Override
    public List<OrderLineResponse> findAllByOrderId(Integer orderId) {
        return orderLineRepository.findAllByOrderId(orderId)
                .stream()
                .map(orderLineMapper::toOrderLineResponse)
                .collect(Collectors.toList());
    }
}
