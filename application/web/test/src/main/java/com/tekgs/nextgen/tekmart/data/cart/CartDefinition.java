package com.tekgs.nextgen.tekmart.data.cart;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tekgs.nextgen.tekmart.data.cart.item.ItemCalibratable;

import java.util.ArrayList;
import java.util.List;

public class CartDefinition implements CartCalibratable {
    List<ItemCalibratable> items = new ArrayList<>();
    String cartID;
    private Integer subTotal;

    public static CartDefinition getInstance() {
        return new CartDefinition();
    }

    public CartDefinition withItem(ItemCalibratable itemDefinition) {
        items.add(itemDefinition);
        return this;
    }

    @Override
    public boolean equivalent(CartCalibratable comparator) {
        return false;
    }

    @Override
    public List<ItemCalibratable> getItems() {
        return items;
    }

    @Override
    public Integer getSubTotal() {
        return this.subTotal;
    }

    @Override
    public String getID() {
        return cartID;
    }

    public CartDefinition withSubTotal(Integer subTotal) {
        this.subTotal = subTotal;
        return this;
    }

    @Override
    public String toString() {
        Gson gson = new GsonBuilder().disableHtmlEscaping().create();
        return gson.toJson(this);
    }
}
