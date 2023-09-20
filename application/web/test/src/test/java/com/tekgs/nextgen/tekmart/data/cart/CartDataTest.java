package com.tekgs.nextgen.tekmart.data.cart;

import com.tekgs.nextgen.tekmart.data.products.ProductsProvider;
import com.tekgs.nextgen.tekmart.data.products.product.Product;
import com.tekgs.nextgen.tekmart.view.products.ProductsView;
import org.softwareonpurpose.gauntlet.GauntletTest;
import org.testng.annotations.Test;

@Test(groups = {GauntletTest.Application.TEKMART, GauntletTest.Data.CART})
public class CartDataTest extends GauntletTest {

    @Test(groups = {TestSuite.SMOKE})
    public void smoke() {
        addRequirements("307 - Product List Page Add to Cart Button Functionality");
        Cart cart = CartProvider.getInstance().get();
        given(cart);
        CartExpected expected = CartExpected.getInstance(cart);
        Cart actual = CartProvider.getInstance().get(cart);
        then(CartCalibrator.getInstance(expected, actual));
    }

    @Test(groups = {TestSuite.DEBUG})
    public void addProductToCart() {
        addRequirements("307 - Product List Page Add to Cart Button Functionality");
        Cart cart = CartProvider.getInstance().get();
        Product productToAdd = ProductsProvider.getInstance().getAll().get(0);
        given(cart, productToAdd);
        CartExpected expected = CartExpected.getInstance(cart).addProduct(productToAdd);
        when();
        ProductsView.directNav().addToCart(productToAdd);
        Cart actual = CartProvider.getInstance().get(cart);
        then(CartCalibrator.getInstance(expected, actual));
    }
}
