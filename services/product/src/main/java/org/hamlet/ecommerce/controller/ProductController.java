package org.hamlet.ecommerce.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.hamlet.ecommerce.payload.request.ProductPurchaseRequest;
import org.hamlet.ecommerce.payload.request.ProductRequest;
import org.hamlet.ecommerce.payload.response.ProductPurchaseResponse;
import org.hamlet.ecommerce.payload.response.ProductResponse;
import org.hamlet.ecommerce.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<Integer> createProduct(@RequestBody @Valid ProductRequest productRequest){
        return ResponseEntity.ok(productService.createProduct(productRequest));
    }

    @PostMapping("/purchase")
    public ResponseEntity<List<ProductPurchaseResponse>> purchaseProducts(
            @RequestBody List<ProductPurchaseRequest> requests){
        return ResponseEntity.ok(productService.purchaseProduct(requests));
    }
    @GetMapping("/{product-id}")
    public ResponseEntity<ProductResponse> findById(@PathVariable("product-id") Integer productId){
        return ResponseEntity.ok(productService.findById(productId));
    }

    @GetMapping
    public ResponseEntity<List<ProductResponse>> findAllProduct(){
        return ResponseEntity.ok(productService.findAll());
    }
}
