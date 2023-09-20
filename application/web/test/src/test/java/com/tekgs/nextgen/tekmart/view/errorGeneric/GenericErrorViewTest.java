package com.tekgs.nextgen.tekmart.view.errorGeneric;

import org.softwareonpurpose.gauntlet.GauntletTest;
import org.testng.annotations.Test;

@Test(groups = {GauntletTest.Application.TEKMART, GauntletTest.View.ERROR})
public class GenericErrorViewTest extends GauntletTest {

    @Test(groups = {TestSuite.SMOKE})
    public void smoke() {
        addRequirements("232 - Error page - system error");
        GenericErrorViewExpected expected = GenericErrorViewExpected.getInstance();
        given();
        when();
        GenericErrorView actual = GenericErrorView.directNav();
        then(GenericErrorViewCalibrator.getInstance(expected, actual));
    }

    @Test(groups = {TestSuite.ACCEPTANCE}, dependsOnMethods = "smoke")
    public void fromSimulateError() {
        addRequirements("232 - Error page - system error");
        GenericErrorViewExpected expected = GenericErrorViewExpected.getInstance();
        given();
        GenericErrorView actual = SimulateErrorView.directNav();
        when();
        then(GenericErrorViewCalibrator.getInstance(expected, actual));
    }

}
