package org.hamlet.ecommerce.payload.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hamlet.ecommerce.enums.PaymentMethod;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderRequest {
    private Integer id;
    private String reference;

    @Positive(message = "Order amount should be positive")
    private BigDecimal amount;

    @NotNull(message = "Payment method should not be precised")
    private PaymentMethod paymentMethod;

    @NotNull(message = "Customer should be present")
    @NotEmpty(message = "Customer should be present")
    @NotBlank(message = "Customer should be present")
    private String customerId;

    List<PurchaseRequest> products; //will the info of the list of products we want to purchase
}
