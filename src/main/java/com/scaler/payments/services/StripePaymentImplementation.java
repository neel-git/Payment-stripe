package com.scaler.payments.services;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentLink;
import com.stripe.model.Price;
import com.stripe.param.PaymentLinkCreateParams;
import com.stripe.param.PriceCreateParams;
import org.springframework.stereotype.Service;

@Service
public class StripePaymentImplementation implements PaymentService{
    @Override
    public String makePayment(String orderId, Long amount) throws StripeException {
        Stripe.apiKey = "sk_test_51Q8oUzErRVzzSCMqHnrv1rTPpoepzVM0XaqaCUdk0EIc3FtSXPHECe7cMwciYf2gkbDbXDt0VIHknCyehGwrOifO009gq56fWh";

        PriceCreateParams params =
                PriceCreateParams.builder()
                        .setCurrency("INR")
                        .setUnitAmount(amount)
                        .setProductData(
                                PriceCreateParams.ProductData.builder().setName(orderId).build()
                        )
                        .build();

        Price price = Price.create(params);

        PaymentLinkCreateParams paymentParams =
                PaymentLinkCreateParams.builder()
                        .addLineItem(
                                PaymentLinkCreateParams.LineItem.builder()
                                        .setPrice(price.getId())
                                        .setQuantity(1L)
                                        .build()
                        )
                        .build();

        PaymentLink paymentLink = PaymentLink.create(paymentParams);
        return paymentLink.getUrl();
    }
}
