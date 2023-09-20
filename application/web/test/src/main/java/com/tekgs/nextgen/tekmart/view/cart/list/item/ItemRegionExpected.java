package com.tekgs.nextgen.tekmart.view.cart.list.item;

import com.tekgs.nextgen.tekmart.data.cart.item.ItemCalibratable;
import com.tekgs.nextgen.tekmart.data.value.Cents;

public class ItemRegionExpected implements ItemRegionCalibratable {
    private final ItemCalibratable item;

    public ItemRegionExpected(ItemCalibratable item) {
        this.item = item;
    }

    public static ItemRegionCalibratable getInstance(ItemCalibratable item) {
        return new ItemRegionExpected(item);
    }

    @Override
    public String getTitle() {
        String productTitle = item.getProduct().getTitle();
        if(productTitle.length() > 100){
            return productTitle.substring(0, 100) + "...";
        }
        return productTitle;
    }

    @Override
    public boolean equivalent(ItemRegionCalibratable expectedItem) {
        return false;
    }

    @Override
    public Integer getQuantity() {
        return item.getQuantity();
    }

    @Override
    public String getPrice() {
        Cents price = Cents.getInstance(this.item.getProduct().getPrice());
        return price.inDollarAmount();
    }
}
