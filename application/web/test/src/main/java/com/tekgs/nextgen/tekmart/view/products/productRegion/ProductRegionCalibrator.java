package com.tekgs.nextgen.tekmart.view.products.productRegion;

import com.softwareonpurpose.calibrator4test.Calibrator;

public class ProductRegionCalibrator extends Calibrator {

    public static final String DESCRIPTION = "Product Region";
    private final ProductRegionCalibratable actual;
    private final ProductRegionCalibratable expected;

    public ProductRegionCalibrator(ProductRegionCalibratable expected, ProductRegionCalibratable actual) {
        super(DESCRIPTION, expected, actual);
        this.expected = expected;
        this.actual = actual;
    }


    public static ProductRegionCalibrator getInstance(ProductRegionCalibratable expected, ProductRegionCalibratable actual) {
        return new ProductRegionCalibrator(expected, actual);
    }

    @Override
    protected void executeVerifications() {
        verify("Title", expected.getTitle(), actual.getTitle());
        verify("Description", expected.getDescription(), actual.getDescription());
        verify("Price", expected.getPrice(), actual.getPrice());
        verify("'Out of Stock' message", expected.getOutofStockMessage(), actual.getOutofStockMessage());
        verify("'Add To Cart' Button", expected.isAddToCartButton(), actual.isAddToCartButton());
    }
}
