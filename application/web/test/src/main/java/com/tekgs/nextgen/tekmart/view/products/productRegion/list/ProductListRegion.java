package com.tekgs.nextgen.tekmart.view.products.productRegion.list;

import com.softwareonpurpose.uinavigator.UiElement;
import com.softwareonpurpose.uinavigator.UiLocatorType;
import com.softwareonpurpose.uinavigator.UiRegion;
import com.tekgs.nextgen.tekmart.view.products.productRegion.ProductRegion;
import com.tekgs.nextgen.tekmart.view.products.productRegion.ProductRegionCalibratable;

import java.util.ArrayList;
import java.util.List;

public class ProductListRegion extends UiRegion implements ProductListRegionCalibratable {

    public static final String DESCRIPTION = "'Product List' Region";
    public static final String LOCATOR_TYPE = UiLocatorType.ID;
    public static final String LOCATOR_VALUE = "product-list";

    protected ProductListRegion(UiElement parentElement) {
        super(UiElement.getInstance(DESCRIPTION, LOCATOR_TYPE, LOCATOR_VALUE, parentElement));
    }

    public static ProductListRegion getInstance(UiElement parentElement) {
        return new ProductListRegion(parentElement);
    }

    @Override
    public List<ProductRegionCalibratable> getProducts() {
        List<ProductRegionCalibratable> productRegions = new ArrayList<>();
        List<UiElement> productElementList = UiElement.getList("Product", UiLocatorType.CLASS, "product", this.getElement());
        productElementList.forEach(productElement -> {
            productRegions.add(ProductRegion.getInstance(productElement));
        });
        return productRegions;
    }
}
