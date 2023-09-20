package com.tekmart.restservice.service;

import com.tekmart.restservice.model.PaymentRequest;
import com.tekmart.restservice.model.PaymentResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PaymentServiceTest {
    @Autowired
    private PaymentService paymentService;

    @Test
    void postValidPayment() {
        PaymentRequest paymentRequest = new PaymentRequest();
        long validAmount = 50L;
        paymentRequest.setAmount(validAmount);
        paymentRequest.setCurrency("USD");
        paymentRequest.setSource("tok_visa");
        PaymentResponse actual = paymentService.post(paymentRequest);
        PaymentResponse expected = new PaymentResponse();
        expected.setMessage("Your purchase has been confirmed \uD83E\uDD11");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void postInvalidPayment() {
        PaymentRequest paymentRequest = new PaymentRequest();
        long invalidAmount = 49L;
        paymentRequest.setAmount(invalidAmount);
        paymentRequest.setCurrency("USD");
        paymentRequest.setSource("tok_visa");
        PaymentResponse actual = paymentService.post(paymentRequest);
        PaymentResponse expected = new PaymentResponse();
        expected.setMessage("We know you're not broke, so try again \uD83D\uDE0F");
        Assertions.assertEquals(expected, actual);
    }
}