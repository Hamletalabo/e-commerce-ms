package org.hamlet.ecommerce.service;

import org.hamlet.ecommerce.entity.Product;
import org.hamlet.ecommerce.payload.request.ProductRequest;
import org.hamlet.ecommerce.payload.response.ProductPurchaseResponse;
import org.hamlet.ecommerce.payload.response.ProductResponse;

public interface ProductMapper {
    Product toProduct(ProductRequest request);

    ProductResponse toProductResponse(Product product);

    ProductPurchaseResponse toProductPurchaseResponse(Product product, double quantity);
}
