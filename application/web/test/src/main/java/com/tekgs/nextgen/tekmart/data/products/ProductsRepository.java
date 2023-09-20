package com.tekgs.nextgen.tekmart.data.products;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.tekgs.nextgen.tekmart.data.products.product.Product;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ProductsRepository {
    public static ProductsRepository getInstance() {
        return new ProductsRepository();
    }

    public List<Product> query() {
        List<Product> productList = new ArrayList<>();
        Path path = Paths.get("../source/inventory.json");
        try (
                BufferedReader reader = Files.newBufferedReader(path)
        ) {
            productList = new Gson().fromJson(reader, new TypeToken<List<Product>>() {
            }.getType());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return productList;
    }
}
