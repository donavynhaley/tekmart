package com.tekgs.nextgen.tekmart.view.cart.list;

import com.tekgs.nextgen.tekmart.data.cart.item.ItemCalibratable;
import com.tekgs.nextgen.tekmart.view.cart.list.item.ItemRegionCalibratable;
import com.tekgs.nextgen.tekmart.view.cart.list.item.ItemRegionExpected;

import java.util.ArrayList;
import java.util.List;

public class ItemListRegionExpected implements ItemListRegionCalibratable {
    private final List<ItemCalibratable> items = new ArrayList<>();

    public ItemListRegionExpected(List<ItemCalibratable> items) {
        this.items.addAll(items);
    }

    public static ItemListRegionExpected getInstance(List<ItemCalibratable> items) {
        return new ItemListRegionExpected(items);
    }

    @Override
    public List<ItemRegionCalibratable> getItems() {
        List<ItemRegionCalibratable> itemRegions = new ArrayList<>();
        this.items.forEach(item -> itemRegions.add(ItemRegionExpected.getInstance(item)));
        return itemRegions;
    }
}
