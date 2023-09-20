package com.tekgs.nextgen.tekmart.view.products.productRegion;

public interface ProductRegionCalibratable {
    String getTitle();

    boolean equivalent(ProductRegionCalibratable comparator);

    String getDescription();

    Integer getPrice();

    String getOutofStockMessage();

    boolean isAddToCartButton();
}
