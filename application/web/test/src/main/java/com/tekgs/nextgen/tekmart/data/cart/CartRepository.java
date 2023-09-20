package com.tekgs.nextgen.tekmart.data.cart;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CartRepository {

    public static CartRepository getInstance() {
        return new CartRepository();
    }

    public List<Cart> query() {
        List<Cart> carts = new ArrayList<>();
        Path path = Paths.get("../source/carts.json");
        try (
                BufferedReader reader = Files.newBufferedReader(path)
        ) {
            carts = new Gson().fromJson(reader, new TypeToken<List<Cart>>() {
            }.getType());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return carts;
    }
}
