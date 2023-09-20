package com.tekgs.nextgen.tekmart.data.cart.item;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tekgs.nextgen.tekmart.data.products.product.ProductCalibratable;
import com.tekgs.nextgen.tekmart.data.products.product.ProductDefinition;

public class ItemDefinition implements ItemCalibratable {
    private ProductCalibratable product;
    private Integer quantity;

    public static ItemDefinition getInstance() {
        return new ItemDefinition();
    }

    public ItemDefinition withProduct(ProductCalibratable product) {
        this.product = product;
        return this;
    }

    public ProductCalibratable getProduct() {
        return this.product;
    }

    @Override
    public boolean equivalent(ItemCalibratable comparator) {
        return false;
    }

    public Integer getQuantity() {
        return this.quantity;
    }

    @Override
    public String toString() {
        Gson gson = new GsonBuilder().disableHtmlEscaping().create();
        return gson.toJson(this);
    }
}
