package com.tekgs.nextgen.tekmart.view.error404;

import org.softwareonpurpose.gauntlet.GauntletTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Test(groups = {GauntletTest.Application.TEKMART, GauntletTest.View.ERROR})
public class ErrorView404Test extends GauntletTest {

    @DataProvider
    public static Object[][] scenarios() {
        String badEndPoint = "bogus";
        String badEndPointWithQueryParameter = "bogus?amount=50";
        String doubleBogus = "bogus/bogus/";
        String validEndPointWithBogus = "purchase-submission/bogus";
        return new Object[][]{
                {badEndPoint},
                {badEndPointWithQueryParameter},
                {doubleBogus},
                {validEndPointWithBogus}
        };
    }

    @Test(groups = {TestSuite.SMOKE})
    public void smoke() {
        addRequirements("231 - Error Page - No Url");
        ErrorView404Expected expected = ErrorView404Expected.getInstance();
        given();
        when();
        ErrorView404 actual = ErrorView404.directNav();
        then(ErrorView404Calibrator.getInstance(expected, actual));
    }

    @Test(groups = {TestSuite.ACCEPTANCE}, dependsOnMethods = "smoke", dataProvider = "scenarios")
    public void directNav(String endPoint) {
        addRequirements("231 - Error Page - No Url");
        ErrorView404Expected expected = ErrorView404Expected.getInstance();
        given(endPoint);
        ErrorView404 actual = ErrorView404.directNav(endPoint);
        then(ErrorView404Calibrator.getInstance(expected, actual));
    }
}
