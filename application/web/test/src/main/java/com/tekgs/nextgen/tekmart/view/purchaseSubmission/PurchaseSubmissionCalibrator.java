package com.tekgs.nextgen.tekmart.view.purchaseSubmission;

import com.softwareonpurpose.calibrator4test.Calibrator;

public class PurchaseSubmissionCalibrator extends Calibrator {
    private static final String DESCRIPTION = "'Purchase Submission' View";
    private final PurchaseSubmissionView actual;
    private final PurchaseSubmissionViewExpected expected;

    public PurchaseSubmissionCalibrator(PurchaseSubmissionViewExpected expected, PurchaseSubmissionView actual) {
        super(DESCRIPTION, expected, actual);
        this.actual = actual;
        this.expected = expected;

    }

    public static PurchaseSubmissionCalibrator getInstance(PurchaseSubmissionViewExpected expected, PurchaseSubmissionView actual) {
        return new PurchaseSubmissionCalibrator(expected, actual);
    }

    @Override
    protected void executeVerifications() {
        verify("Page title", expected.getPageTitle(), actual.getPageTitle());
        verify("'Amount' input field label", expected.getAmountFieldLabel(), actual.getAmountFieldLabel());
        verify("'Amount' input field value", expected.getInputAmount(), actual.getInputAmount());
        verify("'Submit button' is displayed", expected.isSubmitButtonDisplayed(), actual.isSubmitButtonDisplayed());
        verify("'Payment Confirmation' message", expected.getPaymentConfirmationMessage(), actual.getPaymentConfirmationMessage());
        verify("'Source' type", expected.getSource(), actual.getSource());
        verify("'Currency' type", expected.getCurrency(), actual.getCurrency());
    }
}
