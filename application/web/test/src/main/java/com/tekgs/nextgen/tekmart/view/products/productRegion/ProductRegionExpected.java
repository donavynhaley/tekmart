package com.tekgs.nextgen.tekmart.view.products.productRegion;

import com.tekgs.nextgen.tekmart.data.products.product.Product;

public class ProductRegionExpected implements ProductRegionCalibratable {
    private final Product product;
    private boolean isOutOfStock;

    public ProductRegionExpected(Product product) {

        this.product = product;
        this.isOutOfStock=this.product.getStock() <=0;
    }

    public static ProductRegionExpected getInstance(Product product) {
        return new ProductRegionExpected(product);
    }

    @Override
    public String getTitle() {
        return product.getTitle();
    }

    @Override
    public boolean equivalent(ProductRegionCalibratable comparator) {
        return false;
    }

    @Override
    public String getDescription() {
        return product.getDescription();
    }

    @Override
    public Integer getPrice() {
        return product.getPrice();
    }

    @Override
    public String getOutofStockMessage() {
        return isOutOfStock ? "Out of Stock" : "";
    }

    @Override
    public boolean isAddToCartButton() {
        return true;
    }
}
