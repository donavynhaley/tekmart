package com.stripe.api.v1.charges;

public class ChargesResponseExpected implements ChargesResponseCalibratable {
    private final long amount;
    private static final long MAX = 99999999;
    private static final long MIN = 50;

    private ChargesResponseExpected(long amount) {
        this.amount = amount;
    }

    public static ChargesResponseExpected getInstance(long amount) {
        return new ChargesResponseExpected(amount);
    }

    @Override
    public boolean isPaymentSuccessful() {
        return amount >= MIN && amount <= MAX;
    }
}
