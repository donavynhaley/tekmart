package com.tekgs.nextgen.tekmart.view.products;

import com.softwareonpurpose.calibrator4test.Calibrator;
import com.softwareonpurpose.uinavigator.UiRegion;
import com.tekgs.nextgen.tekmart.view.products.productRegion.list.ProductListRegionCalibrator;

public class ProductsViewCalibrator extends Calibrator {

    public static final String DESCRIPTION = "Products View";
    private final ProductsViewExpected expected;
    private final ProductsView actual;

    protected ProductsViewCalibrator(ProductsViewExpected expected, ProductsView actual) {
        super(DESCRIPTION, expected, actual);
        this.expected = expected;
        this.actual = actual;
        UiRegion.suppressConstructionLogging(true);
        addChildCalibrator(ProductListRegionCalibrator.getInstance(expected.inProducts(), actual.inProducts()));
        UiRegion.suppressConstructionLogging(false);

    }

    public static ProductsViewCalibrator getInstance(ProductsViewExpected expected, ProductsView actual) {
        return new ProductsViewCalibrator(expected, actual);
    }

    @Override
    protected void executeVerifications() {
        verify("Header", expected.getProductsHeader(), actual.getProductsHeader());

    }
}
