package com.tekgs.nextgen.tekmart.view.cart.list.item;

import com.softwareonpurpose.calibrator4test.Calibrator;

public class ItemRegionCalibrator extends Calibrator {
    public static final String DESCRIPTION = "item region";
    private ItemRegionCalibratable actual;
    private ItemRegionCalibratable expected;

    public ItemRegionCalibrator(ItemRegionCalibratable expected, ItemRegionCalibratable actual) {
        super(DESCRIPTION, expected, actual);
        this.actual = actual;
        this.expected = expected;
    }

    public static ItemRegionCalibrator getInstance(ItemRegionCalibratable expected, ItemRegionCalibratable actual) {
        return new ItemRegionCalibrator(expected, actual);

    }

    @Override
    protected void executeVerifications() {
        verify("Title", expected.getTitle(), actual.getTitle());
        verify("Price", expected.getPrice(), actual.getPrice());
        verify("Quantity", expected.getQuantity(), actual.getQuantity());
    }

}
