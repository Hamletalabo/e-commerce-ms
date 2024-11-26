package org.hamlet.ecommerce.service;

import jakarta.mail.MessagingException;
import org.hamlet.ecommerce.payload.request.Product;

import java.math.BigDecimal;
import java.util.List;

public interface EmailService {
    void sendPaymentSuccessEmail( String destinationEmail, String customerName, BigDecimal amount,
                                  String orderReference) throws MessagingException;

    void sendOrderConfirmationEmai(String destinationEmail, String customerName, BigDecimal amount,
                                   String orderReference, List<Product> products) throws MessagingException;
}
