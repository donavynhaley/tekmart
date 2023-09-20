package com.tekgs.nextgen.tekmart.view.products;

import com.softwareonpurpose.uinavigator.UiElement;
import com.softwareonpurpose.uinavigator.UiLocatorType;
import com.softwareonpurpose.uinavigator.UiView;
import com.tekgs.nextgen.tekmart.data.products.product.Product;
import com.tekgs.nextgen.tekmart.view.TekmartView;
import com.tekgs.nextgen.tekmart.view.products.productRegion.list.ProductListRegion;

public class ProductsView extends TekmartView implements ProductsViewCalibratable {
    private static final String RELATIVE_URI = "products";
    private static final String DESCRIPTION = "'Products' view";
    private static final String LOCATOR_TYPE = UiLocatorType.ID;
    private static final String LOCATOR_VALUE = "products-view";

    public ProductsView() {
        super(RELATIVE_URI, UiElement.getInstance(DESCRIPTION, LOCATOR_TYPE, LOCATOR_VALUE));
    }

    public static ProductsView directNav() {
        new ProductsView().load();
        return UiView.expect(ProductsView.class);
    }

    @Override
    public String getProductsHeader() {
        return getProductsHeaderElement().getText();
    }

    @Override
    public ProductListRegion inProducts() {
        return ProductListRegion.getInstance(this.getElement());
    }

    private UiElement getProductsHeaderElement() {
        String description = "Products View Header";
        String locatorId = "products-header";
        return getViewElementById(description, locatorId);
    }

    public void addToCart(Product productToAdd) {
        getProductButton(productToAdd.getTitle()).click();
    }

    private UiElement getProductButton(String productTitle) {
        return UiElement.getInstance(productTitle + " button", UiLocatorType.NAME, productTitle, this.getElement());
    }
}
