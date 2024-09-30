package org.hamlet.ecommerce.service;

import org.hamlet.ecommerce.entity.Customer;
import org.hamlet.ecommerce.payload.request.CustomerRequest;

public interface CustomerMapper {
    Customer toCustomer (CustomerRequest request);
}