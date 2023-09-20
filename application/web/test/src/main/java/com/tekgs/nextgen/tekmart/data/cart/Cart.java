package com.tekgs.nextgen.tekmart.data.cart;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tekgs.nextgen.tekmart.data.cart.item.Item;
import com.tekgs.nextgen.tekmart.data.cart.item.ItemCalibratable;
import com.tekgs.nextgen.tekmart.data.cart.item.ItemDefinition;

import java.util.ArrayList;
import java.util.List;

public class Cart implements CartCalibratable {
    String cartID;
    List<Item> items = new ArrayList<>();

    @Override
    public boolean equivalent(CartCalibratable comparator) {
        if (comparator == null)
            return false;
        if(comparator.getID() != null && this.getID().equals(comparator.getID()))
            return true;
        boolean isEquivalent = itemsAreEquivalent(comparator.getItems());
        isEquivalent &= comparator.getSubTotal() == null || getSubTotal().equals(comparator.getSubTotal());
        return isEquivalent;
    }


    private boolean itemsAreEquivalent(List<ItemCalibratable> comparatorItems) {
        List<ItemCalibratable> thisItems = new ArrayList<>(this.items);
        for (ItemCalibratable comparatorItem : comparatorItems) {
            ItemCalibratable itemFound = null;
            for (ItemCalibratable candidate : thisItems) {
                if (candidate.equivalent(comparatorItem)) {
                    itemFound = candidate;
                    break;
                }
            }
            if (itemFound == null)
                return false;
        }
        return true;
    }

    @Override
    public String toString() {
        Gson gson = new GsonBuilder().disableHtmlEscaping().create();
        return gson.toJson(this);
    }

    public String getID() {
        return this.cartID;
    }

    @Override
    public List<ItemCalibratable> getItems() {
        return new ArrayList<>(items);
    }

    @Override
    public Integer getSubTotal() {
        int subtotal = 0;
        for (ItemCalibratable item : this.items) {
            subtotal += item.getProduct().getPrice() * item.getQuantity();
        }
        return subtotal;
    }
}
