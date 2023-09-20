package com.tekmart.service.payment;

import org.softwareonpurpose.gauntlet.GauntletTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Test(groups = {GauntletTest.Endpoint.PURCHASE, GauntletTest.Service.TEKMART_SERVICE})
public class PaymentTests extends GauntletTest {

    @DataProvider
    public static Object[][] dataScenarios() {
        long minimumValidBoundaryAmount = 50L;
        long validAmount = 100L;
        long maxValidBoundaryAmount = 99999999L;
        long minimumInvalidBoundaryAmount = 49L;
        long maximumInvalidBoundaryAmount = 1_000_000_00L;
        long negativeInvalidAmount = -50L;
        return new Object[][]{
                {minimumValidBoundaryAmount},
                {validAmount},
                {maxValidBoundaryAmount},
                {minimumInvalidBoundaryAmount},
                {maximumInvalidBoundaryAmount},
                {negativeInvalidAmount}
        };
    }

    @Test(groups = {TestSuite.SMOKE,TestSuite.ACCEPTANCE})
    public void smoke() {
        addRequirements("223-Purchase Confirmation");
        long amount = 45999L;
        PaymentResponseExpected expected = PaymentResponseExpected.getInstance(amount);
        PaymentResponse actual = PaymentRequest.getInstance(amount).post();
        then(PaymentResponseCalibrator.getInstance(expected, actual));
    }

    @Test(groups = {TestSuite.ACCEPTANCE}, dependsOnMethods = "smoke", dataProvider = "dataScenarios")
    public void post(long amount){
        addRequirements("223-Purchase Confirmation");
        addRequirements("271 - Purchase Submission - Invalid amounts");
        PaymentResponseExpected expected = PaymentResponseExpected.getInstance(amount);
        PaymentResponse actual = PaymentRequest.getInstance(amount).post();
        then(PaymentResponseCalibrator.getInstance(expected, actual));
    }
}
