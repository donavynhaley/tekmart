package com.tekgs.nextgen.tekmart.view.cart.list.item;

import com.softwareonpurpose.uinavigator.UiElement;
import com.softwareonpurpose.uinavigator.UiLocatorType;
import com.softwareonpurpose.uinavigator.UiRegion;

public class ItemRegion extends UiRegion implements ItemRegionCalibratable {
    protected ItemRegion(UiElement parent) {
        super(parent);
    }

    public static ItemRegionCalibratable getInstance(UiElement parent) {
        return new ItemRegion(parent);
    }

    @Override
    public String getTitle() {
        return getTitleElement().getText();
    }

    @Override
    public boolean equivalent(ItemRegionCalibratable comparator) {
        if (comparator == null) return false;
        return comparator.getTitle() == null || this.getTitle().equals(comparator.getTitle());
    }

    @Override
    public Integer getQuantity() {
        return Integer.parseInt(getQuantityElement().getText());
    }

    private UiElement getQuantityElement() {
        return UiElement.getInstance("Quantity", UiLocatorType.CLASS, "item-quantity", this.getElement());
    }

    @Override
    public String getPrice() {
        return getPriceElement().getText();
    }

    private UiElement getPriceElement() {
        return UiElement.getInstance("Price", UiLocatorType.CLASS, "item-price", this.getElement());
    }

    private UiElement getTitleElement() {
        return UiElement.getInstance("Title", UiLocatorType.CLASS, "item-title", this.getElement());
    }
}
