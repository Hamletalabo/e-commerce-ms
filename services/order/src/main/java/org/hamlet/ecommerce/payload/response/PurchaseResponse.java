package org.hamlet.ecommerce.payload.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PurchaseResponse {
    private Integer productId;
    private String name;
    private String description;
    private BigDecimal price;
    private double quantity;
}
