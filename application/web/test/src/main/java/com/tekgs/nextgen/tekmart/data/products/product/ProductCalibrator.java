package com.tekgs.nextgen.tekmart.data.products.product;

import com.softwareonpurpose.calibrator4test.Calibrator;

public class ProductCalibrator extends Calibrator {
    private static final String DESCRIPTION = "'Product' data";
    private final ProductCalibratable actual;
    private final ProductCalibratable expected;

    private ProductCalibrator(ProductCalibratable expected, ProductCalibratable actual) {
        super(DESCRIPTION, expected, actual);
        this.expected = expected;
        this.actual = actual;
    }

    public static ProductCalibrator getInstance(
            ProductCalibratable expected, ProductCalibratable actual) {
        return new ProductCalibrator(expected, actual);
    }

    /**
     *
     */
    @Override
    protected void executeVerifications() {
        verify("Verify Title", expected.getTitle(), actual.getTitle());
        verify("Verify description", expected.getDescription(), actual.getDescription());
        verify("Verify price", expected.getPrice(), actual.getPrice());
        verify("Verify stock", expected.getStock(), actual.getStock());
    }
}
