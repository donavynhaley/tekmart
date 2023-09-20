package com.tekgs.nextgen.tekmart.view;

import com.softwareonpurpose.uinavigator.UiElement;
import com.softwareonpurpose.uinavigator.UiLocatorType;
import com.softwareonpurpose.uinavigator.UiView;

public class TekmartView extends UiView {
    public static final String DOMAIN_URL = "http://localhost:3000";

    protected TekmartView(String relativeUri, UiElement viewElement) {
        super(String.format("%s/%s", DOMAIN_URL, relativeUri), viewElement);
    }

    @Override
    protected boolean confirmElementStates() {
        return this.getElement().waitUntilVisible();
    }

    protected UiElement getViewElementById(String description, String locatorId) {
        return UiElement.getInstance(description, UiLocatorType.ID, locatorId, this.getElement());
    }

    protected UiElement getViewElementByClass(String description, String locatorClass) {
        return UiElement.getInstance(description, UiLocatorType.CLASS, locatorClass, this.getElement());
    }
}
