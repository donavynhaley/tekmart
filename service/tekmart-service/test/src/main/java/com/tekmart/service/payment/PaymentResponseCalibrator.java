package com.tekmart.service.payment;

import com.softwareonpurpose.calibrator4test.Calibrator;

public class PaymentResponseCalibrator extends Calibrator {
    private static final String DESCRIPTION = "'Payment' response";
    private final PaymentResponseExpected expected;
    private final PaymentResponse actual;

    protected PaymentResponseCalibrator(PaymentResponseExpected expected, PaymentResponse actual) {
        super(DESCRIPTION, expected, actual);
        this.expected = expected;
        this.actual = actual;
    }

    public static PaymentResponseCalibrator getInstance(PaymentResponseExpected expected, PaymentResponse actual) {
        return new PaymentResponseCalibrator(expected, actual);
    }

    @Override
    protected void executeVerifications() {
        verify("'Payment Response' Message", expected.getMessage(), actual.getMessage());
    }
}
