package com.tekgs.nextgen.tekmart.view.purchaseSubmission;

public interface PurchaseSubmissionViewCalibratable {
    String getInputAmount();

    String getPageTitle();

    Boolean isSubmitButtonDisplayed();

    String getAmountFieldLabel();

    String getPaymentConfirmationMessage();

    String getSource();

    String getCurrency();
}