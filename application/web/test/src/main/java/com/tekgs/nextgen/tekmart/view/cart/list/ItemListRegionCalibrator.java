package com.tekgs.nextgen.tekmart.view.cart.list;

import com.softwareonpurpose.calibrator4test.Calibrator;
import com.softwareonpurpose.uinavigator.UiRegion;
import com.tekgs.nextgen.tekmart.view.cart.list.item.ItemRegionCalibratable;
import com.tekgs.nextgen.tekmart.view.cart.list.item.ItemRegionCalibrator;

import java.util.List;

public class ItemListRegionCalibrator  extends Calibrator {
    private static final String description = "Item list region" ;

    protected ItemListRegionCalibrator(ItemListRegionExpected expected, ItemListRegion actual) {
        super( description, expected, actual);
        List<ItemRegionCalibratable> expectedItems = expected.getItems();
        List<ItemRegionCalibratable> actualItems = actual.getItems();
        UiRegion.suppressConstructionLogging(true);
        addCalibrationsExpected(expectedItems, actualItems);
        addCalibrationsUnexpected(actualItems);
        UiRegion.suppressConstructionLogging(false);
    }

    public static Calibrator getInstance(ItemListRegionExpected expected, ItemListRegion actual) {
        return new ItemListRegionCalibrator(expected, actual);
    }

    private void addCalibrationsUnexpected(List<ItemRegionCalibratable> actualItems) {
        actualItems.forEach(unexpectedItem -> addChildCalibrator(ItemRegionCalibrator.getInstance(null, unexpectedItem)));
    }

    private void addCalibrationsExpected(List<ItemRegionCalibratable> expectedItems, List<ItemRegionCalibratable> actualItems) {
        expectedItems.forEach(expectedItem -> {
            ItemRegionCalibratable itemFound = addCalibrationFound(actualItems, expectedItem);
            if (itemFound == null) {
                addChildCalibrator(ItemRegionCalibrator.getInstance(expectedItem, null));
            } else {
                actualItems.remove(itemFound);
            }
        });
    }

    private ItemRegionCalibratable addCalibrationFound(List<ItemRegionCalibratable> actualItems, ItemRegionCalibratable expectedItem) {
        ItemRegionCalibratable itemFound = actualItems.stream()
                .filter(actualItem -> actualItem.equivalent(expectedItem))
                .findFirst()
                .orElse(null);
        isItemFoundExist(expectedItem, itemFound);
        return itemFound;
    }

    private void isItemFoundExist(ItemRegionCalibratable itemFound, ItemRegionCalibratable expectedItem) {
        if (itemFound != null) {
            addChildCalibrator(ItemRegionCalibrator.getInstance(expectedItem, itemFound));
        }
    }


    @Override
    protected void executeVerifications() {

    }

}
