package com.stripe.api.v1.charges;

import com.softwareonpurpose.calibrator4test.Calibrator;

public class ChargesResponseCalibrator extends Calibrator {
    private static final String DESCRIPTION = "'Charges' response";
    private final ChargesResponse actual;
    private final ChargesResponseExpected expected;

    private ChargesResponseCalibrator(ChargesResponseExpected expected, ChargesResponse actual) {
        super(DESCRIPTION, expected, actual);
        this.actual = actual;
        this.expected = expected;
    }

    public static Calibrator getInstance(ChargesResponseExpected expected, ChargesResponse actual) {
        return new ChargesResponseCalibrator(expected, actual);
    }

    @Override
    protected void executeVerifications() {
        verify("Is Payment Successful", expected.isPaymentSuccessful(), actual.isPaymentSuccessful());
    }
}
