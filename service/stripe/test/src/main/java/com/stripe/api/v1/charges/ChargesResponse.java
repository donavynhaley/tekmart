package com.stripe.api.v1.charges;

import com.google.gson.Gson;

public class ChargesResponse implements ChargesResponseCalibratable {
    private final String status;
    private final boolean paid;

    private ChargesResponse(String status, boolean paid) {
        this.status = status;
        this.paid = paid;
    }

    public static ChargesResponse getInstance(String responseJson) {
        return new Gson().fromJson(responseJson, ChargesResponse.class);
    }

    @Override
    public boolean isPaymentSuccessful() {
        return "succeeded".equals(status) && paid;
    }
}
