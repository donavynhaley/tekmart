package com.tekgs.nextgen.tekmart.view.products.productRegion.list;

import com.softwareonpurpose.calibrator4test.Calibrator;
import com.tekgs.nextgen.tekmart.view.products.productRegion.ProductRegionCalibratable;
import com.tekgs.nextgen.tekmart.view.products.productRegion.ProductRegionCalibrator;

import java.util.List;

public class ProductListRegionCalibrator extends Calibrator {

    private static final String DESCRIPTION = "Product List Region";

    private ProductListRegionCalibrator(ProductListRegionExpected expected, ProductListRegion actual) {
        super(DESCRIPTION, expected, actual);
        List<ProductRegionCalibratable> expectedProducts = expected.getProducts();
        List<ProductRegionCalibratable> actualProducts = actual.getProducts();
        addCalibrationsExpected(expectedProducts, actualProducts);
        addCalibrationsUnexpected(actualProducts);
    }

    public static Calibrator getInstance(ProductListRegionExpected expected, ProductListRegion actual) {
        return new ProductListRegionCalibrator(expected, actual);
    }

    private void addCalibrationsUnexpected(List<ProductRegionCalibratable> actualProducts) {
        actualProducts.forEach(actualProduct -> {
            addChildCalibrator(ProductRegionCalibrator.getInstance(null, actualProduct));
        });
    }

    private void addCalibrationsExpected(List<ProductRegionCalibratable> expectedProducts, List<ProductRegionCalibratable> actualProducts) {
        expectedProducts.forEach(expectedProduct -> {
            ProductRegionCalibratable productFound = addCalibrationsFound(actualProducts, expectedProduct);
            if (productFound == null) {
                addChildCalibrator(ProductRegionCalibrator.getInstance(expectedProduct, null));
            } else {
                actualProducts.remove(productFound);
            }

        });
    }

    private ProductRegionCalibratable addCalibrationsFound(List<ProductRegionCalibratable> actualProducts, ProductRegionCalibratable expectedProduct) {
        ProductRegionCalibratable productFound = actualProducts.stream()
                .filter(actualProduct -> actualProduct.equivalent(expectedProduct))
                .findFirst()
                .orElse(null);
        if (productFound != null) {
            addChildCalibrator(ProductRegionCalibrator.getInstance(expectedProduct, productFound));
        }
        return productFound;
    }

    @Override
    protected void executeVerifications() {

    }
}
