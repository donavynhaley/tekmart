package com.tekgs.nextgen.tekmart.view.cart;

import com.softwareonpurpose.uinavigator.UiElement;
import com.softwareonpurpose.uinavigator.UiLocatorType;
import com.softwareonpurpose.uinavigator.UiView;
import com.tekgs.nextgen.tekmart.view.TekmartView;
import com.tekgs.nextgen.tekmart.view.cart.list.ItemListRegion;

public class CartView extends TekmartView implements CartViewCalibratable {
    private static final String RELATIVE_URI = "cart";
    private static final String DESCRIPTION = "'Cart' view";
    private static final String LOCATOR_TYPE = UiLocatorType.ID;
    private static final String LOCATOR_VALUE = "cart-view";

    public CartView() {
        super(RELATIVE_URI, UiElement.getInstance(DESCRIPTION, LOCATOR_TYPE, LOCATOR_VALUE));
    }

    public static CartView directNav() {
        new CartView().load();
        return UiView.expect(CartView.class);
    }

    public static CartView directNav(String cartId) {
        String relativeUri = String.format("?cartId=%s", cartId);
        new CartView().load(relativeUri);
        return UiView.expect(CartView.class);
    }

    @Override
    public String getEmptyMessage() {
        return getEmptyMessageElement().getText();
    }

    @Override
    public ItemListRegion inItems() {
        return ItemListRegion.getInstance(this.getElement());
    }

    @Override
    public String getSubtotal() {
        return getSubtotalElement().getText();
    }

    private UiElement getSubtotalElement() {
        String locatorValue = "subtotal";
        String description = "Subtotal";
        return getViewElementByClass(description, locatorValue);
    }

    private UiElement getEmptyMessageElement() {
        String description = "Empty message";
        String locatorValue = "empty-message";
        return getViewElementById(description, locatorValue);
    }
}
