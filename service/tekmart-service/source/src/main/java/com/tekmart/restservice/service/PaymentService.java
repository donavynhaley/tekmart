package com.tekmart.restservice.service;


import com.tekmart.restservice.model.PaymentRequest;
import com.tekmart.restservice.model.PaymentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class PaymentService {
    @Autowired
    private Environment environment;
    private static final String BASE_URL = "https://api.stripe.com";
    private static final String URI = "v1/charges";
    private static final String PATH_URL = String.format("%s/%s", BASE_URL, URI);
    private String BEARER_TOKEN;

    private static Mono<PaymentResponse> apply(ClientResponse response) {
        if (response.statusCode().equals(HttpStatus.OK)) {
            PaymentResponse successPaymentResponse = new PaymentResponse();
            successPaymentResponse.setMessage("Your purchase has been confirmed \uD83E\uDD11");
            return Mono.just(successPaymentResponse);
        } else if (response.statusCode().equals(HttpStatus.BAD_REQUEST)) {
            PaymentResponse failedPaymentResponse = new PaymentResponse();
            failedPaymentResponse.setMessage("We know you're not broke, so try again \uD83D\uDE0F");
            return Mono.just(failedPaymentResponse);
        }
        return null;
    }

    public PaymentResponse post(PaymentRequest paymentRequest) {
        return getPaymentResponse(paymentRequest);
    }

    private PaymentResponse getPaymentResponse(PaymentRequest paymentRequest) {
        BEARER_TOKEN = environment.getProperty("stripe.apiKey");
        return WebClient.builder().build()
                .post()
                .uri(PATH_URL)
                .header("Authorization", BEARER_TOKEN)
                .body(BodyInserters.fromFormData(create(paymentRequest)))
                .exchangeToMono(PaymentService::apply)
                .block();
    }

    private MultiValueMap<String, String> create(PaymentRequest paymentRequest) {
        MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<>();
        requestBody.add("amount", String.valueOf(paymentRequest.getAmount()));
        requestBody.add("currency", paymentRequest.getCurrency());
        requestBody.add("source", paymentRequest.getSource());
        return requestBody;
    }

}

