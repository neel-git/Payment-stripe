package com.scaler.payments.services;

import com.stripe.exception.StripeException;

public interface PaymentService {
    String makePayment(String orderId, Long amount) throws StripeException;
}
