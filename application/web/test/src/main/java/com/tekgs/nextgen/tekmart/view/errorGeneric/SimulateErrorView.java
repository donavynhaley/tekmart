package com.tekgs.nextgen.tekmart.view.errorGeneric;

import com.softwareonpurpose.uinavigator.UiElement;
import com.softwareonpurpose.uinavigator.UiLocatorType;
import com.softwareonpurpose.uinavigator.UiView;
import com.tekgs.nextgen.tekmart.view.TekmartView;

public class SimulateErrorView extends TekmartView {
    private static final String RELATIVE_URI = "simulate-unhandled-exception";
    private static final String DESCRIPTION = "'Simulate Error' view";
    private static final String LOCATOR_TYPE = UiLocatorType.ID;
    private static final String LOCATOR_VALUE = "simulate-error-view";

    public SimulateErrorView() {
        super(RELATIVE_URI, UiElement.getInstance(DESCRIPTION, LOCATOR_TYPE, LOCATOR_VALUE));
    }

    public static GenericErrorView directNav() {
        new SimulateErrorView().load();
        return UiView.expect(GenericErrorView.class);
    }
}
