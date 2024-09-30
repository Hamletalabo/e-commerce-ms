package org.hamlet.ecommerce.service;

import org.hamlet.ecommerce.payload.response.CustomerResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient(name = "customer-service", url = "${application.config.customer-url}")
public interface CustomerClient {

    @GetMapping("/{customer-id}")
    Optional<CustomerResponse> findById(@PathVariable("customer-id") String customerId);

}
