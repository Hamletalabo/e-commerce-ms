package org.hamlet.ecommerce.payload.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductPurchaseResponse {

    private Integer productId;

    private String name;

    private String description;

    private BigDecimal price;

    private double quantity;
}
