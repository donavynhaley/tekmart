package com.tekgs.nextgen.tekmart.data.cart.item;

import com.tekgs.nextgen.tekmart.data.products.product.Product;

public class Item implements ItemCalibratable {
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
        if (comparatorItem == null) return false;
        boolean isEquivalent = comparatorItem.getProduct() == null || this.product.equivalent(comparatorItem.getProduct());
        isEquivalent &= comparatorItem.getQuantity() == null || this.quantity.equals(comparatorItem.getQuantity());
        return isEquivalent;
    }

    @Override
    public String toString() {
        return "Item{" +
                "quantity=" + quantity +
                ", product=" + product +
                '}';
    }
}
