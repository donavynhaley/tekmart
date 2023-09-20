package com.tekgs.nextgen.tekmart.view.errorGeneric;

public class GenericErrorViewExpected implements GenericErrorViewCalibratable {
    private static final String ERROR_MESSAGE = "Looks like the internet ate our page. Please navigate back to the homepage.";

    public static GenericErrorViewExpected getInstance() {
        return new GenericErrorViewExpected();
    }

    @Override
    public String getErrorMessage() {
        return ERROR_MESSAGE;
    }
}
