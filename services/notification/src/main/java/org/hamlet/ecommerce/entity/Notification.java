package org.hamlet.ecommerce.entity;

import lombok.*;
import org.hamlet.ecommerce.enums.NotificationType;
import org.hamlet.ecommerce.payload.request.OrderConfirmationRequest;
import org.hamlet.ecommerce.payload.request.PaymentConfirmationRequest;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document
@Builder
public class Notification {
    @Id
    private String id;
    private NotificationType notificationType;
    private LocalDateTime notificationDate;
    private OrderConfirmationRequest orderConfirmation;
    private PaymentConfirmationRequest paymentConfirmationRequest;
}
