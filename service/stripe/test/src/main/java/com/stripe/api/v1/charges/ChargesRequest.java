package com.stripe.api.v1.charges;

import jakarta.ws.rs.client.*;
import jakarta.ws.rs.core.Form;
import jakarta.ws.rs.core.Response;
import org.softwareonpurpose.gauntlet.Environment;

public class ChargesRequest {
    private static final String BASE_URL = Environment.getInstance().getBaseUrl();
    private static final String STRIPE_SECRET_KEY = Environment.getInstance().getStripeSecretKey();
    private final Client client = ClientBuilder.newBuilder().build();
    private final WebTarget target = client.target(String.format("%s/charges", BASE_URL));
    private final Invocation.Builder request = target.request();
    private final long amount;

    private ChargesRequest(long amount) {
        this.amount = amount;
    }

    public static ChargesRequest getInstance(long amount) {
        return new ChargesRequest(amount);
    }

    public Entity<Form> create() {
        Form chargeParams = new Form();
        chargeParams.param("amount", String.valueOf(amount));
        chargeParams.param("currency", "usd");
        chargeParams.param("source", "tok_visa");

        return Entity.form(chargeParams);
    }

    public ChargesResponse post() {
        request.header("Authorization", "Bearer " + STRIPE_SECRET_KEY);
        Response stripeResponse = request.post(this.create());
        ChargesResponse chargesResponse = ChargesResponse.getInstance(stripeResponse.readEntity(String.class));
        stripeResponse.close();

        return chargesResponse;
    }
}
