package com.tekgs.nextgen.tekmart.data.products.product;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Product implements ProductCalibratable {
    Integer price;
    String title;
    String description;
    Integer stock;

    private Product() {
    }

    @Override
    public boolean equivalent(ProductCalibratable product) {
        boolean isEquivalent = product.getTitle() == null || this.title.equals(product.getTitle());
        isEquivalent &= product.getPrice() == null || this.price.equals(product.getPrice());
        return isEquivalent;
    }

    @Override
    public String getTitle() {
        return this.title;
    }

    @Override
    public Integer getPrice() {
        return this.price;
    }

    @Override
    public Integer getStock() {
        return this.stock;
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public String toString() {
        Gson gson = new GsonBuilder().disableHtmlEscaping().create();
        return gson.toJson(this);
    }

}
