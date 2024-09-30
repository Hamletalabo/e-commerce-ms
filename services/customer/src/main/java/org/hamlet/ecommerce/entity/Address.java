package org.hamlet.ecommerce.entity;

import lombok.*;
import org.springframework.validation.annotation.Validated;

@AllArgsConstructor
@Getter
@Setter
@Builder
@NoArgsConstructor
@Validated
public class Address {

    private String street;
    private String houseNumber;
    private String zipcode;

}
