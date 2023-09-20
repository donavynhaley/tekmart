package com.tekgs.nextgen.tekmart.view.cart;

import com.tekgs.nextgen.tekmart.data.cart.Cart;
import com.tekgs.nextgen.tekmart.data.cart.item.ItemCalibratable;
import com.tekgs.nextgen.tekmart.data.value.Cents;
import com.tekgs.nextgen.tekmart.view.cart.list.ItemListRegionExpected;

import java.util.ArrayList;
import java.util.List;

public class CartViewExpected implements CartViewCalibratable {
    public static final String CART_IS_EMPTY_MESSAGE = "Your cart is empty";
    private final Cart cart;
    private final List<ItemCalibratable> items;
    private final Cents subTotal;

    public CartViewExpected(Cart cart) {
        this.cart = cart;
        this.items = cart == null ? new ArrayList<>() : cart.getItems();
        this.subTotal = cart == null ? null : Cents.getInstance(cart.getSubTotal());
    }

    public static CartViewExpected getInstance() {
        return new CartViewExpected(null);
    }

    public static CartViewExpected getInstance(Cart cart) {
        return new CartViewExpected(cart);
    }

    @Override
    public String getEmptyMessage() {
        return cart == null ? CART_IS_EMPTY_MESSAGE : null;
    }

    @Override
    public ItemListRegionExpected inItems() {
        return ItemListRegionExpected.getInstance(items);
    }

    @Override
    public String getSubtotal() {
        return this.subTotal == null ? null : this.subTotal.inDollarAmount();
    }
}
