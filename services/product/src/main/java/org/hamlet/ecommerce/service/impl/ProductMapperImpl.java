package org.hamlet.ecommerce.service.impl;

import lombok.AllArgsConstructor;
import org.hamlet.ecommerce.entity.Category;
import org.hamlet.ecommerce.entity.Product;
import org.hamlet.ecommerce.payload.request.ProductRequest;
import org.hamlet.ecommerce.payload.response.ProductPurchaseResponse;
import org.hamlet.ecommerce.payload.response.ProductResponse;
import org.hamlet.ecommerce.service.ProductMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductMapperImpl implements ProductMapper {
    @Override
    public Product toProduct(ProductRequest request) {
        return Product.builder()
                .id(request.getId())
                .name(request.getName())
                .description(request.getDescription())
                .price(request.getPrice())
                .availableQuantity(request.getAvailableQuantity())
                .category(
                        Category.builder()
                                .id(request.getCategory_id())
                                .build())
                .build();
    }

    @Override
    public ProductResponse toProductResponse(Product product) {
        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getAvailableQuantity(),
                product.getPrice(),
                product.getCategory().getId(),
                product.getCategory().getName(),
                product.getCategory().getDescription()
        );
    }

    @Override
    public ProductPurchaseResponse toProductPurchaseResponse(Product product, double quantity) {
        return new ProductPurchaseResponse(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                quantity
        );
    }
}
