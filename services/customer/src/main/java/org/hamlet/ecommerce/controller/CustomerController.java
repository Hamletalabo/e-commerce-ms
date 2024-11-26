package org.hamlet.ecommerce.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.hamlet.ecommerce.payload.request.CustomerRequest;
import org.hamlet.ecommerce.payload.response.CustomerResponse;
import org.hamlet.ecommerce.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/customers")
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping("/createCustomer")
    public ResponseEntity<String> createCustomer(@RequestBody @Valid CustomerRequest request){
        return ResponseEntity.ok(customerService.createCustomer(request));
    }

    @PutMapping("/updateCustomer")
    public ResponseEntity<String> updateCustomer(@RequestBody @Valid CustomerRequest request){
        return ResponseEntity.ok(customerService.updateCustomer(request));
    }

    @GetMapping("/findAllCustomers")
    public ResponseEntity<List<CustomerResponse>> findAllCustomers(){
        return ResponseEntity.ok(customerService.findAllCustomers());
    }

    @GetMapping("/{customer-id}")
    public ResponseEntity<CustomerResponse> findById(@PathVariable("customer-id") String customerId){
        return ResponseEntity.ok(customerService.findById(customerId));
    }

    @GetMapping("/exist/{customer-id}")
    public ResponseEntity<Boolean> existById(@PathVariable("customer-id") String customerId){
        return ResponseEntity.ok(customerService.existById(customerId));
    }

    @DeleteMapping("/delete/{customer-id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable("customer-id") String customerId){
        return ResponseEntity.ok(customerService.deleteCustomer(customerId));
    }

}
