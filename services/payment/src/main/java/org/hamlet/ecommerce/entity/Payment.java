package org.hamlet.ecommerce.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hamlet.ecommerce.enums.PaymentMethod;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static jakarta.persistence.EnumType.STRING;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity()
@Table(name = "payment")
@EntityListeners(AllArgsConstructor.class)
public class Payment {

    @Id
    @GeneratedValue
    private Integer id;
    private BigDecimal amount;

    @Enumerated(STRING)
    private PaymentMethod paymentMethod;
    private Integer orderId;

    @CreatedDate
    @Column(updatable = false, nullable = false)
    private LocalDateTime createAt;

    @LastModifiedDate
    @Column(insertable = false)
    private LocalDateTime lastModifiedDate;
}
