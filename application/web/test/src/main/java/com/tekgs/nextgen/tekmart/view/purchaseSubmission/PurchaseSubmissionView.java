package com.tekgs.nextgen.tekmart.view.purchaseSubmission;

import com.softwareonpurpose.uinavigator.UiElement;
import com.softwareonpurpose.uinavigator.UiLocatorType;
import com.softwareonpurpose.uinavigator.UiView;
import com.softwareonpurpose.uinavigator.web.WebUiHost;
import com.tekgs.nextgen.tekmart.view.TekmartView;

import java.util.List;

public class PurchaseSubmissionView extends TekmartView implements PurchaseSubmissionViewCalibratable {
    private static final String RELATIVE_URI = "purchase-submission";
    private static final String DESCRIPTION = "'Purchase Submission' View";
    private static final String LOCATOR_TYPE = UiLocatorType.ID;
    private static final String LOCATOR_VALUE = "purchase-submission-view";

    public PurchaseSubmissionView() {
        super(RELATIVE_URI, UiElement.getInstance(DESCRIPTION, LOCATOR_TYPE, LOCATOR_VALUE));
    }

    public static PurchaseSubmissionView directNav() {
        new PurchaseSubmissionView().load();
        return UiView.expect(PurchaseSubmissionView.class);
    }

    public static PurchaseSubmissionView directNav(long amount) {
        String relativeUri = String.format("?amount=%d", amount);
        new PurchaseSubmissionView().load(relativeUri);
        return UiView.expect(PurchaseSubmissionView.class);
    }

    @Override
    protected boolean confirmElementStates() {
        return WebUiHost.getInstance().getAddress().contains(RELATIVE_URI);
    }

    @Override
    public String getInputAmount() {
        return getInputAmountElement().getText();
    }

    @Override
    public String getPageTitle() {
        return getPageTitleElement().getText();
    }

    @Override
    public Boolean isSubmitButtonDisplayed() {
        return getSubmitButtonElement().isDisplayed();
    }

    @Override
    public String getAmountFieldLabel() {
        return getAmountLabelElement().getText();
    }

    @Override
    public String getPaymentConfirmationMessage() {
        return getPaymentConfirmationMessageElement().getText();
    }

    @Override
    public String getSource() {
        return getSourceElement().getAttribute("value");
    }

    @Override
    public String getCurrency() {
        return getCurrencyElement().getText();
    }

    private UiElement getCurrencyElement() {
        String description = "'Currency' text";
        String locatorValue = "currency";
        return getViewElementById(description, locatorValue);
    }

    private UiElement getSourceElement() {
        String description = "'Source' text";
        String locatorValue = "source-dropdown";
        return getViewElementById(description, locatorValue);
    }

    private UiElement getPaymentConfirmationMessageElement() {
        String description = "'Status' message";
        String locatorValue = "status-message";
        return getViewElementById(description, locatorValue);
    }

    private UiElement getAmountLabelElement() {
        String description = "'Amount' label";
        String locatorValue = "amount-label";
        return getViewElementById(description, locatorValue);
    }

    private UiElement getPageTitleElement() {
        String description = "'Checkout' Page Title";
        String locatorValue = "checkout-page-title";
        return getViewElementById(description, locatorValue);
    }

    private UiElement getInputAmountElement() {
        String description = "Amount input field";
        String locatorValue = "amount-input-element";
        return getViewElementById(description, locatorValue);
    }

    private UiElement getSubmitButtonElement() {
        String description = "Submit Button";
        String locatorValue = "submit-button";
        return getViewElementById(description, locatorValue);
    }

    public PurchaseSubmissionView submit() {
        getSubmitButtonElement().click();
        return UiView.expect(PurchaseSubmissionView.class);
    }

    public PurchaseSubmissionView selectSource(String source) {
        getSourceElement().click();
        getSourceDropdownElements().forEach(sourceElement -> {
            if (sourceElement.getAttribute("value").equalsIgnoreCase(source)) {
                sourceElement.click();
            }
        });
        return UiView.expect(PurchaseSubmissionView.class);
    }

    private List<UiElement> getSourceDropdownElements() {
        String description = "Source dropdown elements";
        String locatorValue = "source-option";
        return UiElement.getList(description, UiLocatorType.CLASS, locatorValue, this.getElement());
    }
}