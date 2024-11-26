package org.hamlet.ecommerce.payload.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderLineRequest {
    private Integer id;
    private Integer orderId;
    private Integer productId;
    private double quantity;
}
