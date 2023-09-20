package com.tekgs.nextgen.tekmart.view.products.productRegion;

import com.softwareonpurpose.uinavigator.UiElement;
import com.softwareonpurpose.uinavigator.UiLocatorType;
import com.softwareonpurpose.uinavigator.UiRegion;

import javax.swing.*;

public class ProductRegion extends UiRegion implements ProductRegionCalibratable{
    protected ProductRegion(UiElement regionElement) {
        super(regionElement);
    }

    public static ProductRegion getInstance(UiElement parent) {
        return new ProductRegion(parent);
    }

    @Override
    public String getTitle() {
        return getTitleElement().getText();
    }

    @Override
    public boolean equivalent(ProductRegionCalibratable comparator) {
        if(comparator == null) return false;
        String title = this.getTitle();
        return comparator.getTitle() == null || title.equals(comparator.getTitle());
    }

    @Override
    public Integer getPrice() {
        return Integer.parseInt(getPriceElement().getText());
    }

    @Override
    public String getOutofStockMessage() {
        return getOutofStockMessageElement().getText();
    }

    @Override
    public boolean isAddToCartButton() {
        return getAddToCartButtonElement().isDisplayed();
    }

    public void clickAddToCartButton() {
        this.getAddToCartButtonElement().click();
    }

    private UiElement getAddToCartButtonElement() {
        String description = "Add To Cart Button";
        String locatorValue = "add-to-cart";
        return UiElement.getInstance(description, UiLocatorType.CLASS, locatorValue, this.getElement());
    }

    private UiElement getOutofStockMessageElement() {
        String description = "'Out Of Stock' message";
        String locatorValue = "out-of-stock";
        return UiElement.getInstance(description, UiLocatorType.CLASS, locatorValue, this.getElement());
    }

    @Override
    public String getDescription(){
        return getDescriptionElement().getText();
    }

    private UiElement getDescriptionElement() {
        String locatorValue = "product-description";
        String description = "Description";
        return UiElement.getInstance(description, UiLocatorType.CLASS, locatorValue, this.getElement());
    }

    private UiElement getPriceElement() {
        String price = "Price";
        String locatorValue = "product-price";
        return UiElement.getInstance(price, UiLocatorType.CLASS, locatorValue, this.getElement());
    }

    private UiElement getTitleElement() {
        String description = "Title";
        String locatorValue = "product-title";
        return UiElement.getInstance(description, UiLocatorType.CLASS, locatorValue, this.getElement());
    }
}
