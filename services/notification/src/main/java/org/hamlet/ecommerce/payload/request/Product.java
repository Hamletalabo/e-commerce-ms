package org.hamlet.ecommerce.payload.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Product {
    private Integer productId;
    private String  name;
    private String description;
    private BigDecimal price;
    private double quantity;

}
