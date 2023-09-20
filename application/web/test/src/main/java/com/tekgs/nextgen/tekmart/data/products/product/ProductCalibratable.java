package com.tekgs.nextgen.tekmart.data.products.product;

public interface ProductCalibratable {
    Integer getPrice();
    String getTitle();
    String getDescription();
    Integer getStock();
    boolean equivalent(ProductCalibratable comparator);
}
