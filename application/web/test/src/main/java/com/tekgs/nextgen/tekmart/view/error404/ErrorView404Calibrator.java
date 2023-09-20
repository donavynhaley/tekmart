package com.tekgs.nextgen.tekmart.view.error404;

import com.softwareonpurpose.calibrator4test.Calibrator;

public class ErrorView404Calibrator extends Calibrator {
    public static final String DESCRIPTION = "'Error' view";
    private final ErrorView404Expected expected;
    private final ErrorView404 actual;

    public ErrorView404Calibrator(ErrorView404Expected expected, ErrorView404 actual) {
        super(DESCRIPTION, expected, actual);
        this.expected = expected;
        this.actual = actual;
    }

    public static Calibrator getInstance(ErrorView404Expected expected, ErrorView404 actual) {
        return new ErrorView404Calibrator(expected, actual);
    }

    @Override
    protected void executeVerifications() {
        verify("404 Error", expected.getError404Message(), actual.getError404Message());
    }
}
