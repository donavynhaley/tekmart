package com.stripe.api.v1.charges;

import org.softwareonpurpose.gauntlet.GauntletTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Test(groups={GauntletTest.Service.STRIPE, GauntletTest.Endpoint.CHARGES})
public class ChargesTests extends GauntletTest {

    @DataProvider
    public static Object[][] scenarios() {
        long minNotAllowed = 49;
        long minAllowed = 50;
        long maxAllowed = 99999999;
        long maxNotAllowed = 100000000;
        long negativeNumber = -50;
        return new Object[][]{
                {minNotAllowed},
                {minAllowed},
                {maxAllowed},
                {maxNotAllowed},
                {negativeNumber}
        };
    }

    @Test(groups={TestSuite.SMOKE})
    public void smoke() {
        addRequirements("221 - Purchase Confirmation");
        long amountInCents = 50L;
        ChargesResponse actual = ChargesRequest.getInstance(amountInCents).post();
        ChargesResponseExpected expected = ChargesResponseExpected.getInstance(amountInCents);
        then(ChargesResponseCalibrator.getInstance(expected, actual));
    }

    @Test(groups = {TestSuite.ACCEPTANCE, TestSuite.RELEASE}, dependsOnMethods = "smoke", dataProvider = "scenarios")
    public void post(long amount) {
        addRequirements("221 - Purchase Confirmation");
        ChargesResponseExpected expected = ChargesResponseExpected.getInstance(amount);
        ChargesResponse actual = ChargesRequest.getInstance(amount).post();
        then(ChargesResponseCalibrator.getInstance(expected, actual));
    }
}
