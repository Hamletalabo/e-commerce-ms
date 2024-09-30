package org.hamlet.ecommerce.service.impl;

import com.ctc.wstx.util.StringUtil;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang.StringUtils;
import org.hamlet.ecommerce.entity.Customer;
import org.hamlet.ecommerce.exception.CustomerNotFoundException;
import org.hamlet.ecommerce.payload.request.CustomerRequest;
import org.hamlet.ecommerce.payload.response.CustomerResponse;
import org.hamlet.ecommerce.repository.CustomerRepository;
import org.hamlet.ecommerce.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerMapperImpl customerMapper;

    @Override
    public String createCustomer(CustomerRequest customerRequest) {
        var customer = customerRepository.save(customerMapper.toCustomer(customerRequest));

        return customer.getFirstname();
    }

    @Override
    public String updateCustomer(CustomerRequest request) {
        var customer = customerRepository.findById(request.getId()).orElseThrow(
                () -> new CustomerNotFoundException(String.format(
                        "Cannot update customer:: Customer not found with the ID"
                        , request.getId())));

        mergeCustomer(customer, request);
        customerRepository.save(customer);
        return "Customer updated successfully";
    }

    @Override
    public List<CustomerResponse> findAllCustomers() {
        return customerRepository.findAll()
                .stream()
                .map(customerMapper::fromCustomer)
                .collect(Collectors.toList());
    }

    @Override
    public Boolean existById(String customerId) {
        return customerRepository.findById(customerId).isPresent();
    }

    @Override
    public CustomerResponse findById(String customerId) {
        return customerRepository.findById(customerId)
                .map(customerMapper::fromCustomer)
                .orElseThrow(() -> new CustomerNotFoundException(
                        String.format("No customer found with the provided ID:: %s", customerId)));

    }

    @Override
    public String deleteCustomer(String customerId) {
        customerRepository.deleteById(customerId);
        return "Customer has been deleted successfully";
    }

    private void mergeCustomer(Customer customer, CustomerRequest request) {
        if (StringUtils.isNotBlank(request.getFirstname())){
            customer.setFirstname(request.getFirstname());
        }
        if (StringUtils.isNotBlank(request.getLastname())){
            customer.setFirstname(request.getLastname());
        }
        if (StringUtils.isNotBlank(request.getEmail())){
            customer.setFirstname(request.getEmail());
        }
        if (request.getAddress() != null){
            customer.setAddress(request.getAddress());
        }
    }
}
