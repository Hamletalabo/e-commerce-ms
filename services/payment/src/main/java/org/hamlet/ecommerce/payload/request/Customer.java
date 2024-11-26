package org.hamlet.ecommerce.payload.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;

@Validated
public record Customer(
        String id,

        @NotNull(message = "Firstname is required")
        String firstname,
        @NotNull(message = "Lastname is required")
        String lastname,

        @Email(message = "invalid email format")
        @NotNull(message = "Firstname is required")
        String email
) {
}
