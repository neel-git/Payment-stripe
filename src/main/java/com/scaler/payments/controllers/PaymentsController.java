package com.scaler.payments.controllers;

import com.scaler.payments.dtos.PaymentRequestDto;
import com.scaler.payments.services.PaymentService;
import com.stripe.exception.StripeException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentsController {


    private final PaymentService paymentService;

    public PaymentsController(PaymentService paymentService){
        this.paymentService = paymentService;
    }

    @PostMapping("/payments")
    public ResponseEntity<String> createPaymentLink(@RequestBody PaymentRequestDto paymentRequestDto) throws StripeException {
        String paymentLink = paymentService.makePayment(paymentRequestDto.getOrderId(),paymentRequestDto.getPaymentAmount());
        return new ResponseEntity<>(paymentLink, HttpStatus.OK);
    }
}