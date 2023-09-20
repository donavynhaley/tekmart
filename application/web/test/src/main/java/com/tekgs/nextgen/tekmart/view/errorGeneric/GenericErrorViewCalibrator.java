package com.tekgs.nextgen.tekmart.view.errorGeneric;

import com.softwareonpurpose.calibrator4test.Calibrator;

public class GenericErrorViewCalibrator extends Calibrator {

    private static final String DESCRIPTION = "Error";
    private final GenericErrorViewExpected expected;
    private final GenericErrorView actual;

    protected GenericErrorViewCalibrator(GenericErrorViewExpected expected, GenericErrorView actual) {
        super(DESCRIPTION, expected, actual);
        this.expected = expected;
        this.actual = actual;
    }

    public static GenericErrorViewCalibrator getInstance(GenericErrorViewExpected expected, GenericErrorView actual) {
        return new GenericErrorViewCalibrator(expected, actual);
    }

    @Override
    protected void executeVerifications() {
        verify("Generic Error Message", expected.getErrorMessage(), actual.getErrorMessage());
    }
}
