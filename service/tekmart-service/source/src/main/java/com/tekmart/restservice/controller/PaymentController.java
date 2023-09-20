package com.tekmart.restservice.controller;

import com.tekmart.restservice.model.PaymentRequest;
import com.tekmart.restservice.model.PaymentResponse;
import com.tekmart.restservice.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.*;

@RestController
@RequestMapping("/purchase")
@CrossOrigin(origins = "http://localhost:3000/")
@ControllerAdvice
public class PaymentController {

  @Autowired
  private PaymentService paymentService;

  @PostMapping(consumes = {APPLICATION_JSON_VALUE}, produces = {APPLICATION_JSON_VALUE})
  public PaymentResponse postPaymentToStripe(@RequestBody PaymentRequest paymentRequest){
    return paymentService.post(paymentRequest);
  }

}
