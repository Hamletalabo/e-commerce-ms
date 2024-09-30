package org.hamlet.ecommerce.service;

import org.hamlet.ecommerce.payload.request.CustomerRequest;
import org.hamlet.ecommerce.payload.response.CustomerResponse;

import java.util.List;

public interface CustomerService {
    String createCustomer (CustomerRequest customerRequest);

    String updateCustomer(CustomerRequest request);

    List<CustomerResponse> findAllCustomers();

    Boolean existById(String customerId);

    CustomerResponse findById(String customerId);

    String deleteCustomer(String customerId);
}
