package org.hamlet.ecommerce.service.impl;

import lombok.RequiredArgsConstructor;
import org.hamlet.ecommerce.entity.Customer;
import org.hamlet.ecommerce.payload.request.CustomerRequest;
import org.hamlet.ecommerce.payload.response.CustomerResponse;
import org.hamlet.ecommerce.service.CustomerMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerMapperImpl implements CustomerMapper {

    @Override
    public Customer toCustomer(CustomerRequest request) {
        if (request == null){return null;}
        return Customer.builder()
                .id(request.getId())
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .email(request.getEmail())
                .address(request.getAddress())
                .build();
    }

    public CustomerResponse fromCustomer(Customer customer) {
        return new CustomerResponse(
                customer.getId(),
                customer.getFirstname(),
                customer.getLastname(),
                customer.getEmail(),
                customer.getAddress()
        );
    }
}
