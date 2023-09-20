package com.tekgs.nextgen.tekmart.data.products;

import com.tekgs.nextgen.tekmart.data.products.product.Product;

import java.util.List;

public class ProductsProvider {

    public static ProductsProvider getInstance() {
        return new ProductsProvider();
    }

    public List<Product> getAll() {
        return ProductsRepository.getInstance().query();
    }
}
