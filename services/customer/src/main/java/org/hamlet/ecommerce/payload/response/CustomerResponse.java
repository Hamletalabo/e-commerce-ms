package org.hamlet.ecommerce.payload.response;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hamlet.ecommerce.entity.Address;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerResponse {

    private String id;

    private String firstname;


    private String lastname;


    private String email;

    private Address address;
}
