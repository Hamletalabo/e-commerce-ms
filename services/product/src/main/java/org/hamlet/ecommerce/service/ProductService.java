package org.hamlet.ecommerce.service;

import org.hamlet.ecommerce.payload.request.ProductPurchaseRequest;
import org.hamlet.ecommerce.payload.request.ProductRequest;
import org.hamlet.ecommerce.payload.response.ProductPurchaseResponse;
import org.hamlet.ecommerce.payload.response.ProductResponse;

import java.util.List;

public interface ProductService {
    Integer createProduct(ProductRequest productRequest);

    List<ProductPurchaseResponse> purchaseProduct(List<ProductPurchaseRequest> requests);

    ProductResponse findById(Integer productId);

    List<ProductResponse> findAll();
}
