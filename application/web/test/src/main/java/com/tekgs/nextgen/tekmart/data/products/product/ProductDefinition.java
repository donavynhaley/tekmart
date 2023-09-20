package com.tekgs.nextgen.tekmart.data.products.product;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ProductDefinition implements ProductCalibratable {
    private String title;
    private Integer price;
    private String description;
    private Integer stock;

    private ProductDefinition() {
    }

    public static ProductDefinition getInstance() {
        return new ProductDefinition();
    }

    public ProductDefinition withTitle(String title) {
        this.title = title;
        return this;
    }

    @Override
    public String getTitle() {
        return this.title;
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public Integer getStock() {
        return this.stock;
    }

    @Override
    public boolean equivalent(ProductCalibratable comparator) {
        return false;
    }

    @Override
    public Integer getPrice() {
        return this.price;
    }

    @Override
    public String toString() {
        Gson gson = new GsonBuilder().disableHtmlEscaping().create();
        return gson.toJson(this);
    }
}