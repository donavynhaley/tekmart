package com.tekgs.nextgen.tekmart.data.cart.item;

import com.tekgs.nextgen.tekmart.data.products.product.Product;

public class ItemExpected implements ItemCalibratable {
    Integer quantity;
    Product product;

    @Override
    public Integer getQuantity() {
        return quantity;
    }

    @Override
    public Product getProduct() {
        return product;
    }

    @Override
    public boolean equivalent(ItemCalibratable comparatorItem) {
        return false;
    }
}
