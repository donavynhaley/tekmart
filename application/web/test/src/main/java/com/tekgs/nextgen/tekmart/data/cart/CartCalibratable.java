package com.tekgs.nextgen.tekmart.data.cart;

import com.tekgs.nextgen.tekmart.data.cart.item.ItemCalibratable;

import java.util.List;

public interface CartCalibratable {
    boolean equivalent(CartCalibratable comparator);

    List<ItemCalibratable> getItems();

    Integer getSubTotal();

    String getID();
}
