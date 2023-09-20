package com.tekgs.nextgen.tekmart.view.cart.list.item;

public interface ItemRegionCalibratable {

    String getTitle();

    boolean equivalent(ItemRegionCalibratable expectedItem);

    Integer getQuantity();

    String getPrice();
}
