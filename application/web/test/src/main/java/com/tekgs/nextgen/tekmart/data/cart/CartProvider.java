package com.tekgs.nextgen.tekmart.data.cart;

import java.util.List;

public class CartProvider {
    public static CartProvider getInstance() {
        return new CartProvider();
    }

    public Cart get(CartCalibratable cartCalibratable) {
        List<Cart> cartList = CartRepository.getInstance().query();
        Cart cart = null;
        for (Cart candidate : cartList) {
            if (candidate.equivalent(cartCalibratable)) {
                cart = candidate;
                break;
            }
        }
        return cart;
    }

    public Cart get() {
        return CartRepository.getInstance().query().get(0);
    }
}
