package com.tekgs.nextgen.tekmart.view.products.productRegion.list;

import com.tekgs.nextgen.tekmart.data.products.product.Product;
import com.tekgs.nextgen.tekmart.view.products.productRegion.ProductRegionCalibratable;
import com.tekgs.nextgen.tekmart.view.products.productRegion.ProductRegionExpected;

import java.util.ArrayList;
import java.util.List;

public class ProductListRegionExpected implements ProductListRegionCalibratable {
    private final List<Product> productsList = new ArrayList<>();

    public ProductListRegionExpected(List<Product> productsList) {
        this.productsList.addAll(productsList);
    }

    public static ProductListRegionExpected getInstance(List<Product> productsList) {
        return new ProductListRegionExpected(productsList);
    }

    @Override
    public List<ProductRegionCalibratable> getProducts() {
        List<ProductRegionCalibratable> productExpectedList = new ArrayList<>();
        productsList.forEach(product -> {
            productExpectedList.add(ProductRegionExpected.getInstance(product));
        });
        return productExpectedList;
    }
}
