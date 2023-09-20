package com.tekgs.nextgen.tekmart.view.purchaseSubmission;

import org.softwareonpurpose.gauntlet.GauntletTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Test(groups = {GauntletTest.Application.TEKMART, GauntletTest.View.PURCHASE_SUBMISSION})
public class PurchaseSubmissionTests extends GauntletTest {

    @DataProvider
    public static Object[][] scenarios() {
        String sourceAmex = "tok_amex";
        String sourceVisa = "tok_visa";
        String sourceVisaDebit = "tok_visa_debit";
        long invalidNegativeAmount = -50L;
        long outsideLowerBoundary = 49L;
        long validLowerBoundary = 50L;
        long fiveDollars = 500L;
        long tenDollars = 1000L;
        long validHighBoundary = 99999999L;
        long outsideHighBoundary = 100000000L;
        return new Object[][]{
                {invalidNegativeAmount, sourceAmex},
                {outsideLowerBoundary, sourceVisa},
                {validLowerBoundary, sourceVisaDebit},
                {validHighBoundary, sourceVisa},
                {fiveDollars, sourceVisa},
                {tenDollars, sourceAmex},
                {outsideHighBoundary, sourceVisaDebit}
        };
    }

    @DataProvider
    public static Object[][] submitPaymentAmountScenarios() {
        String sourceAmex = "tok_amex";
        String sourceVisa = "tok_visa";
        String sourceVisaDebit = "tok_visa_debit";
        long outsideLowerBoundary = 49L;
        long validLowerBoundary = 50L;
        long validHighBoundary = 99999999L;
        long validIntermediateValue = 50000000L;
        return new Object[][]{
                {outsideLowerBoundary, sourceAmex},
                {validLowerBoundary, sourceAmex},
                {validHighBoundary, sourceVisa},
                {validIntermediateValue, sourceVisaDebit}
        };
    }

    @Test(groups = {TestSuite.SMOKE})
    public void smoke() {
        addRequirements("225 - Purchase Submission - Payment Data");
        given();
        PurchaseSubmissionViewExpected expected = PurchaseSubmissionViewExpected.getInstance();
        when();
        PurchaseSubmissionView actual = PurchaseSubmissionView.directNav();
        then(PurchaseSubmissionCalibrator.getInstance(expected, actual));
    }

    @Test(groups = {TestSuite.ACCEPTANCE, TestSuite.RELEASE}, dependsOnMethods = "smoke", dataProvider = "scenarios")
    public void directNav(Long amount, String source) {
        addRequirements("225 - Purchase Submission - Payment Data");
        given(amount, source);
        PurchaseSubmissionViewExpected expected = PurchaseSubmissionViewExpected.getInstance(amount, source);
        when();
        PurchaseSubmissionView actual = PurchaseSubmissionView.directNav(amount).selectSource(source);
        then(PurchaseSubmissionCalibrator.getInstance(expected, actual));
    }

    @Test(groups = {TestSuite.ACCEPTANCE, TestSuite.RELEASE}, dependsOnMethods = "smoke", dataProvider = "submitPaymentAmountScenarios")
    public void submit(Long amount, String source) {
        addRequirements("225 - Purchase Submission - Payment Data");
        given(amount, source);
        PurchaseSubmissionViewExpected expected = PurchaseSubmissionViewExpected.getSubmittedInstance(amount, source);
        when();
        PurchaseSubmissionView actual = PurchaseSubmissionView.directNav(amount).selectSource(source).submit();
        then(PurchaseSubmissionCalibrator.getInstance(expected, actual));
    }
}
