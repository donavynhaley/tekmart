package com.tekgs.nextgen.tekmart.view.products;

import com.tekgs.nextgen.tekmart.data.products.ProductsProvider;
import com.tekgs.nextgen.tekmart.data.products.product.Product;
import org.softwareonpurpose.gauntlet.GauntletTest;
import org.testng.annotations.Test;

import java.util.List;

@Test(groups = {GauntletTest.Application.TEKMART, GauntletTest.View.PRODUCTS})
public class ProductsViewTest extends GauntletTest {

    @Test(groups = {TestSuite.SMOKE, TestSuite.ACCEPTANCE})
    public void smoke() {
        addRequirements(
                "238 Products page- Display Products",
                "235 Products' view - Display Out of Stock indicator if a product is not in stock",
                "237 Products List View - Add Product to cart"
        );
        List<Product> productList = ProductsProvider.getInstance().getAll();
        given(productList);
        ProductsViewExpected expected = ProductsViewExpected.getInstance(productList);
        when();
        ProductsView actual = ProductsView.directNav();
        then(ProductsViewCalibrator.getInstance(expected, actual));
    }

}
