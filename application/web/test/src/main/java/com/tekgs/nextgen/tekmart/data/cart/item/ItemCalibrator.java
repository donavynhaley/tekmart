package com.tekgs.nextgen.tekmart.data.cart.item;

import com.softwareonpurpose.calibrator4test.Calibrator;
import com.tekgs.nextgen.tekmart.data.products.product.ProductCalibratable;
import com.tekgs.nextgen.tekmart.data.products.product.ProductCalibrator;

public class ItemCalibrator extends Calibrator {

    public static final String DESCRIPTION = "'Item' Data ";
    private final ItemCalibratable expected;
    private final ItemCalibratable actual;

    private ItemCalibrator(ItemCalibratable expected, ItemCalibratable actual) {
        super(DESCRIPTION, expected, actual);
        this.expected = expected;
        this.actual = actual;
        ProductCalibratable expectedProduct = expected != null ? expected.getProduct() : null;
        ProductCalibratable actualProduct = actual != null ? actual.getProduct() : null;
        addChildCalibrator(ProductCalibrator.getInstance(expectedProduct, actualProduct));
    }

    public static ItemCalibrator getInstance(ItemCalibratable expected, ItemCalibratable actual) {
        return new ItemCalibrator(expected, actual);
    }

    @Override
    protected void executeVerifications() {
        verify("quantity", expected.getQuantity(), actual.getQuantity());
    }
}
