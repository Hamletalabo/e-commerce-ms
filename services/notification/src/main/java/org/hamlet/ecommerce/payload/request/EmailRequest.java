package org.hamlet.ecommerce.payload.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmailRequest {
    private String destinationEmail;
    private String customerName;
    private BigDecimal amount;
    private String orderReference;
}
