package com.tekmart.service.payment;

import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import org.softwareonpurpose.gauntlet.Environment;

public class PaymentRequest {
    private static final String PATH = Environment.getInstance().getPath();
    private final long amount;
    private final ResteasyWebTarget target;

    private PaymentRequest(long amount) {
        ResteasyClient client = (ResteasyClient) ClientBuilder.newBuilder().build();
        target = client.target(UriBuilder.fromPath(PATH));
        this.amount = amount;
    }

    public static PaymentRequest getInstance(long amount) {
        return new PaymentRequest(amount);
    }

    public PaymentResponse post() {
        PaymentResponse paymentResponse;
        try (Response response = target.request().post(getPaymentRequestBodyEntity())) {
            paymentResponse = response.readEntity(PaymentResponse.class);
        }
        return paymentResponse;
    }

    private Entity<PaymentRequestBody> getPaymentRequestBodyEntity() {
        PaymentRequestBody paymentRequestBodyEntity = PaymentRequestBody.getInstance(amount);
        return Entity.json(paymentRequestBodyEntity);
    }
}
