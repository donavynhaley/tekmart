package com.tekmart.service.payment;

public class PaymentRequestBody {
    private long amount;
    private String currency = "USD";
    private String source = "tok_visa";

    private PaymentRequestBody(long amount) {
        this.amount = amount;
    }

    public static PaymentRequestBody getInstance(long amount) {
        return new PaymentRequestBody(amount);
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}
