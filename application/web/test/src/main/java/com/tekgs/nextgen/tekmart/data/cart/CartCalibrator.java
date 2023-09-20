package com.tekgs.nextgen.tekmart.data.cart;

import com.softwareonpurpose.calibrator4test.Calibrator;
import com.tekgs.nextgen.tekmart.data.cart.item.ItemCalibratable;
import com.tekgs.nextgen.tekmart.data.cart.item.ItemCalibrator;

import java.util.ArrayList;
import java.util.List;

public class CartCalibrator extends Calibrator {

    public static final String DESCRIPTION = "'Cart' Data";

    private CartCalibrator(CartExpected expected, Cart actual) {
        super(DESCRIPTION, expected, actual);
        List<ItemCalibratable> actualItemList = new ArrayList<>(actual.getItems());
        List<ItemCalibratable> expectedItemList = expected.getItems();
        addCalibrationsExpected(expectedItemList, actualItemList);
        addCalibrationsUnexpected(actualItemList);
    }

    public static CartCalibrator getInstance(CartExpected expected, Cart actual) {
        return new CartCalibrator(expected, actual);
    }

    private void addCalibrationsExpected(List<ItemCalibratable> expectedItemList, List<ItemCalibratable> actualItemList) {
        expectedItemList.forEach(expectedItem -> {
            ItemCalibratable itemFound = addCalibrationsFound(actualItemList, expectedItem);
            if (itemFound == null) {
                addChildCalibrator(ItemCalibrator.getInstance(expectedItem, null));
            } else {
                actualItemList.remove(itemFound);
            }
        });
    }

    private ItemCalibratable addCalibrationsFound(List<ItemCalibratable> actualItemList, ItemCalibratable expectedItem) {
        ItemCalibratable itemFound = actualItemList.stream()
                .filter(actualItem -> actualItem.equivalent(expectedItem))
                .findFirst()
                .orElse(null);
        if (itemFound != null) {
            addChildCalibrator(ItemCalibrator.getInstance(expectedItem, itemFound));
        }
        return itemFound;
    }

    private void addCalibrationsUnexpected(List<ItemCalibratable> actualItemList) {
        actualItemList.forEach(itemUnexpected -> addChildCalibrator(ItemCalibrator.getInstance(null, itemUnexpected)));
    }

    @Override
    protected void executeVerifications() {
    }
}
