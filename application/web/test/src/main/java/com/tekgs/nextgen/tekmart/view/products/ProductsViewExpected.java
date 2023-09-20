package com.tekgs.nextgen.tekmart.view.products;

import com.tekgs.nextgen.tekmart.data.products.product.Product;
import com.tekgs.nextgen.tekmart.view.products.productRegion.list.ProductListRegionExpected;

import java.util.ArrayList;
import java.util.List;

public class ProductsViewExpected implements ProductsViewCalibratable{

    private static final String PRODUCTS_PAGE_HEADER = "Products Page";
    private final List<Product> productsList = new ArrayList<>();

    public ProductsViewExpected(List<Product> productList) {
        this.productsList.addAll(productList);
    }


    public static ProductsViewExpected getInstance(List<Product> productList) {
        return new ProductsViewExpected(productList);
    }

    @Override
    public String getProductsHeader() {
        return PRODUCTS_PAGE_HEADER;
    }

    @Override
    public ProductListRegionExpected inProducts() {
        return ProductListRegionExpected.getInstance(productsList);
    }

    public List<Product> getProducts() {
        return this.productsList;
    }
}
