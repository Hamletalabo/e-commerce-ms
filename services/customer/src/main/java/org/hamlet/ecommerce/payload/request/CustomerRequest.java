package org.hamlet.ecommerce.payload.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hamlet.ecommerce.entity.Address;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerRequest {

    private String id;

    @NotNull(message = "Firstname is required")
    private String firstname;

    @NotNull(message = "Lastname is required")
    private String lastname;

    @Email(message = "Not a valid email")
    private String email;

    private Address address;
}
