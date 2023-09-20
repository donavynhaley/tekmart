package com.tekgs.nextgen.tekmart.data.cart;

import com.tekgs.nextgen.tekmart.data.cart.item.ItemCalibratable;
import com.tekgs.nextgen.tekmart.data.cart.item.ItemDefinition;
import com.tekgs.nextgen.tekmart.data.products.product.Product;
import com.tekgs.nextgen.tekmart.data.products.product.ProductCalibratable;

import java.util.ArrayList;
import java.util.List;

public class CartExpected implements CartCalibratable {
    private final CartCalibratable cart;
    private final List<ItemCalibratable> items;

    private CartExpected(CartCalibratable cart) {
        this.cart = cart;
        this.items = new ArrayList<>(cart.getItems());
    }

    public static CartExpected getInstance(CartCalibratable cart) {
        return new CartExpected(cart);
    }

    @Override
    public boolean equivalent(CartCalibratable comparator) {
        return false;
    }

    @Override
    public List<ItemCalibratable> getItems() {
        return this.items;
    }

    @Override
    public Integer getSubTotal() {
        return cart.getSubTotal();
    }

    @Override
    public String getID() {
        return cart.getID();
    }

    public CartExpected addProduct(ProductCalibratable productToAdd) {
        ItemCalibratable itemToAdd = ItemDefinition.getInstance().withProduct(productToAdd);
        this.items.add(itemToAdd);
        return this;
    }
}
