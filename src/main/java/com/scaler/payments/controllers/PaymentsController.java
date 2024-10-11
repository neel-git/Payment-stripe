package com.scaler.payments.controllers;

import com.scaler.payments.dtos.PaymentRequestDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentsController {

    @PostMapping("/payments")
    public String createPaymentLink(@RequestBody PaymentRequestDto paymentRequestDto) {
        return "";
    }
}