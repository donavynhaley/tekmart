package com.tekgs.nextgen.tekmart.view.cart;

import com.tekgs.nextgen.tekmart.data.cart.Cart;
import com.tekgs.nextgen.tekmart.data.cart.CartDefinition;
import com.tekgs.nextgen.tekmart.data.cart.CartProvider;
import com.tekgs.nextgen.tekmart.data.cart.item.ItemDefinition;
import com.tekgs.nextgen.tekmart.data.products.product.ProductDefinition;
import org.softwareonpurpose.gauntlet.GauntletTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Test(groups = {GauntletTest.Application.TEKMART, GauntletTest.View.CART})
public class CartViewTest extends GauntletTest {

    @DataProvider
    public static Object[][] scenarios() {
        ProductDefinition productWithEmptyString = ProductDefinition.getInstance().withTitle("");
        ProductDefinition productWithHtmlScriptTag = ProductDefinition.getInstance().withTitle("<h1>Test</h1>");
        ProductDefinition productWithSpecialCharacter = ProductDefinition.getInstance().withTitle("(U+2408)");
        ProductDefinition productWithSqlQuery = ProductDefinition.getInstance().withTitle("SELECT * FROM cart");
        ProductDefinition productWithSeparatedBySpace = ProductDefinition.getInstance().withTitle("Product 1");
        

        ProductDefinition titleOverOneHundred = ProductDefinition.getInstance().withTitle("abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijlkmnopqr");
        ProductDefinition titleLessOneHundred = ProductDefinition.getInstance().withTitle("abcdefghijklmnopqrstuvwxyzabcdefghijklmn");
        ProductDefinition titleEqualOneHundred = ProductDefinition.getInstance().withTitle("abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuv");

        ItemDefinition itemWithEmptyString = ItemDefinition.getInstance().withProduct(productWithEmptyString);
        ItemDefinition itemWithHTML = ItemDefinition.getInstance().withProduct(productWithHtmlScriptTag);
        ItemDefinition itemWithSpecialCharacter = ItemDefinition.getInstance().withProduct(productWithSpecialCharacter);
        ItemDefinition itemWithSql = ItemDefinition.getInstance().withProduct(productWithSqlQuery);
        ItemDefinition itemWithSeparatedBySpace = ItemDefinition.getInstance().withProduct(productWithSeparatedBySpace);

        ItemDefinition itemWithTitleOverOneHundred = ItemDefinition.getInstance().withProduct(titleOverOneHundred);
        ItemDefinition itemWithTitleLessOneHundred = ItemDefinition.getInstance().withProduct(titleLessOneHundred);
        ItemDefinition itemWithTitleEqualOneHundred = ItemDefinition.getInstance().withProduct(titleEqualOneHundred);

        return new Object[][]{
                {CartDefinition.getInstance().withItem(itemWithEmptyString)},
                {CartDefinition.getInstance().withItem(itemWithHTML)},
                {CartDefinition.getInstance().withItem(itemWithSpecialCharacter)},
                {CartDefinition.getInstance().withItem(itemWithSql)},
                {CartDefinition.getInstance().withItem(itemWithSeparatedBySpace)},
                {CartDefinition.getInstance().withSubTotal(50)},
                {CartDefinition.getInstance().withSubTotal(99999999)},
                {CartDefinition.getInstance().withSubTotal(50000000)},
                {CartDefinition.getInstance().withItem(itemWithTitleOverOneHundred)},
                {CartDefinition.getInstance().withItem(itemWithTitleLessOneHundred)},
                {CartDefinition.getInstance().withItem(itemWithTitleEqualOneHundred)},



        };
    }

    @Test(groups = {TestSuite.SMOKE, TestSuite.RELEASE})
    public void smoke() {
        addRequirements("226 - Shopping Cart - Empty Shopping Cart Message", "227 - Shopping Cart - Items List");
        CartViewExpected expect = CartViewExpected.getInstance();
        CartView actual = CartView.directNav();
        then(CartViewCalibrator.getInstance(expect, actual));
    }

    @Test(groups = {TestSuite.ACCEPTANCE, TestSuite.RELEASE}, dependsOnMethods = "smoke", dataProvider = "scenarios")
    public void directNav(CartDefinition cartDefinition) {
        addRequirements(
                "226 - Shopping Cart - Empty Shopping Cart Message",
                "227 - Shopping Cart - Items List",
                "224 - Shopping Cart Subtotal",
                "311 - Shopping Cart Calculate Subtotal",
                "288 - Cart View - Truncated Titles"
        );
        Cart cart = CartProvider.getInstance().get(cartDefinition);
        given(cart);
        CartViewExpected expect = CartViewExpected.getInstance(cart);
        CartView actual = CartView.directNav(cart.getID());
        then(CartViewCalibrator.getInstance(expect, actual));
    }
}
