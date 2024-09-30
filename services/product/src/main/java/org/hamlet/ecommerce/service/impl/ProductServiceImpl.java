package org.hamlet.ecommerce.service.impl;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.hamlet.ecommerce.exception.ProductPurchaseException;
import org.hamlet.ecommerce.payload.request.ProductPurchaseRequest;
import org.hamlet.ecommerce.payload.request.ProductRequest;
import org.hamlet.ecommerce.payload.response.ProductPurchaseResponse;
import org.hamlet.ecommerce.payload.response.ProductResponse;
import org.hamlet.ecommerce.repository.ProductRepository;
import org.hamlet.ecommerce.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapperImpl productMapper;

    @Override
    public Integer createProduct(ProductRequest productRequest) {
        var product = productMapper.toProduct(productRequest);
        return productRepository.save(product).getId();
    }

    @Override
    public List<ProductPurchaseResponse> purchaseProduct(List<ProductPurchaseRequest> requests) {
        var  productId = requests
                .stream()
                .map(ProductPurchaseRequest::getProductId)
                .toList(); // extract the list of products IDs
        var storedProducts = productRepository.findAllByIdInOrderById(productId);// check product availability
        if (productId.size() != storedProducts.size()){
            throw new ProductPurchaseException("One or more products does not exists");
        }//
        var storesRequest = requests
                .stream()
                .sorted(Comparator.comparing(ProductPurchaseRequest::getProductId))
                .toList(); // extract the IDs of the stored requests
        var purchasedProducts = new ArrayList<ProductPurchaseResponse>(); //an object of purchased products
  //check if product qty is already available
        for (int i = 0; i < storedProducts.size(); i++) {
            var product = storedProducts.get(i);
            var productRequest = storesRequest.get(i);
            if (product.getAvailableQuantity() < productRequest.getQuantity()){
                throw new ProductPurchaseException(
                        "Insufficient stock quantity for product with ID :: "
                                + productRequest.getProductId());
            }
            //updating or recalculate the available qty
            var newAvailableQuantity = product.getAvailableQuantity() - productRequest.getQuantity();
            product.setAvailableQuantity(newAvailableQuantity);
            productRepository.save(product);
            //return the list of the purchased products
            purchasedProducts.add(productMapper.toProductPurchaseResponse(product, productRequest.getQuantity()));
        }
        return purchasedProducts;
    }

    @Override
    public ProductResponse findById(Integer productId) {
        return productRepository.findById(productId)
                .map(productMapper::toProductResponse)
                .orElseThrow(()-> new EntityNotFoundException("Product not found with the id:: " + productId));
    }

    @Override
    public List<ProductResponse> findAll() {
        return productRepository.findAll()
                .stream()
                .map(productMapper::toProductResponse)
                .collect(Collectors.toList());
    }

}
