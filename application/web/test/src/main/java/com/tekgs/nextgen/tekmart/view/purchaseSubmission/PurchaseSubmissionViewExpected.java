package com.tekgs.nextgen.tekmart.view.purchaseSubmission;

import java.text.NumberFormat;
import java.util.Locale;

public class PurchaseSubmissionViewExpected implements PurchaseSubmissionViewCalibratable {
    public static final String DEFAULT_SOURCE = "select_source";
    public static final String DEFAULT_CURRENCY = "USD";
    private final boolean isSubmitted;
    private final String source;
    private final String currency;
    private Long amount;

    private PurchaseSubmissionViewExpected(Long amount, boolean isSubmitted, String source) {
        this.amount = amount;
        this.isSubmitted = isSubmitted;
        this.source = source == null ? DEFAULT_SOURCE : source;
        this.currency = DEFAULT_CURRENCY;
    }

    public static PurchaseSubmissionViewExpected getInstance() {
        return new PurchaseSubmissionViewExpected(null, false, null);
    }

    public static PurchaseSubmissionViewExpected getInstance(long amount, String source) {
        return new PurchaseSubmissionViewExpected(amount, false, source);
    }

    public static PurchaseSubmissionViewExpected getSubmittedInstance(Long amount, String source) {
        return new PurchaseSubmissionViewExpected(amount, true, source);
    }

    private String getFormattedAmount() {
        Double amountValueInDollars = amount.doubleValue() / 100;
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(Locale.US);
        return String.format(numberFormat.format(amountValueInDollars));
    }

    @Override
    public String getInputAmount() {
        amount = amount == null ? 0 : amount;
        return getFormattedAmount();
    }

    @Override
    public String getPageTitle() {
        return "Checkout";
    }

    @Override
    public Boolean isSubmitButtonDisplayed() {
        return true;
    }

    @Override
    public String getAmountFieldLabel() {
        return "Amount:";
    }

    @Override
    public String getPaymentConfirmationMessage() {
        if (amount == null || !isSubmitted) {
            return "";
        }
        return isValidAmount() ? "Your purchase has been confirmed \uD83E\uDD11" : "We know you're not broke, so try again \uD83D\uDE0F";
    }

    @Override
    public String getSource() {
        return this.source;
    }

    @Override
    public String getCurrency() {
        return this.currency;
    }

    private boolean isValidAmount() {
        return amount > 49 && amount < 100_000_000;
    }

}
