package com.tekmart.service.payment;

public class PaymentResponseExpected implements PaymentResponseCalibratable {
    private final Long amount;
    private static final int STRIPE_LOWER_VALID_BOUNDARY = 50;
    private static final int STRIPE_UPPER_VALID_BOUNDARY = 99999999;

    public PaymentResponseExpected(Long amount) {
        this.amount = amount;
    }

    public static PaymentResponseExpected getInstance(Long amount) {
        return new PaymentResponseExpected(amount);
    }

    private Boolean isValidAmount() {
        return this.amount != null && this.amount >= STRIPE_LOWER_VALID_BOUNDARY && this.amount <= STRIPE_UPPER_VALID_BOUNDARY;
    }

    @Override
    public String getMessage() {
        return isValidAmount() ? "Your purchase has been confirmed \uD83E\uDD11" : "We know you're not broke, so try again \uD83D\uDE0F";
    }
}
