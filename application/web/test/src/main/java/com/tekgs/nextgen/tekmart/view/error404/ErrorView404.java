package com.tekgs.nextgen.tekmart.view.error404;

import com.softwareonpurpose.uinavigator.UiElement;
import com.softwareonpurpose.uinavigator.UiLocatorType;
import com.softwareonpurpose.uinavigator.UiView;

public class ErrorView404 extends UiView implements ErrorView404Calibratable {
    private static final String BASE_URI = "http://localhost:3000";
    private static final String DESCRIPTION = "'Error' View";
    private static final String LOCATOR_TYPE = UiLocatorType.ID;
    private static final String LOCATOR_VALUE = "__next";

    public ErrorView404() {
        super(BASE_URI, UiElement.getInstance(DESCRIPTION, LOCATOR_TYPE, LOCATOR_VALUE));
    }

    public static ErrorView404 directNav() {
        new ErrorView404().load();
        return UiView.expect(ErrorView404.class);
    }

    public static ErrorView404 directNav(String relativeURI) {
        new ErrorView404().load(relativeURI);
        return UiView.expect(ErrorView404.class);
    }

    @Override
    public String getError404Message() {
        return getError404Element().getText();
    }

    private UiElement getError404Element() {
        String description = "404 Error";
        String locatorClass = "next-error-h1";
        return UiElement.getInstance(description, UiLocatorType.CLASS, locatorClass);
    }

    @Override
    protected boolean confirmElementStates() {
        return getError404Element().isDisplayed();
    }
}
