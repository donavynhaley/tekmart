package com.tekgs.nextgen.tekmart.view.errorGeneric;

import com.softwareonpurpose.uinavigator.UiElement;
import com.softwareonpurpose.uinavigator.UiLocatorType;
import com.softwareonpurpose.uinavigator.UiView;
import com.tekgs.nextgen.tekmart.view.TekmartView;

public class GenericErrorView extends TekmartView implements GenericErrorViewCalibratable {
    private static final String RELATIVE_URI = "error";
    private static final String DESCRIPTION = "'Generic Error' view";
    private static final String LOCATOR_TYPE = UiLocatorType.ID;
    private static final String LOCATOR_VALUE = "generic-error-view";

    public GenericErrorView() {
        super(RELATIVE_URI, UiElement.getInstance(DESCRIPTION, LOCATOR_TYPE, LOCATOR_VALUE));
    }

    public static GenericErrorView directNav() {
        new GenericErrorView().load();
        return UiView.expect(GenericErrorView.class);
    }

    @Override
    public String getErrorMessage() {
        String description = "Error Message";
        String locatorId = "error-message";
        return getViewElementById(description, locatorId).getText();
    }
}
