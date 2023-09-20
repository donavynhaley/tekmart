package com.tekgs.nextgen.tekmart.view.error404;

public class ErrorView404Expected implements ErrorView404Calibratable {
    public static final String ERROR_MESSAGE_404 = "404";

    public static ErrorView404Expected getInstance() {
        return new ErrorView404Expected();
    }

    @Override
    public String getError404Message() {
        return ERROR_MESSAGE_404;
    }
}
