package com.tekgs.nextgen.tekmart.data.cart.item;

import com.tekgs.nextgen.tekmart.data.products.product.ProductCalibratable;

public interface ItemCalibratable {
    Integer getQuantity();

    ProductCalibratable getProduct();

    boolean equivalent(ItemCalibratable comparator);
}
