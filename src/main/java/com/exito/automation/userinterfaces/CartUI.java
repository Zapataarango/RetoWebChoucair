package com.exito.automation.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class CartUI {

    public static final Target LBL_CART_PRODUCT_NAME = Target.the("Product label in cart")
            .locatedBy("(//a[@class='exito-checkout-product-name'])");

    public static final Target LBL_CART_PRODUCT_PRICE = Target.the("Product price label in cart")
            .locatedBy("//span[@class='new-product-price']");

    public static final Target LBL_TOTAL_QUANTITY = Target.the("Product quantity label in cart")
            .locatedBy("//div[@class='totalItems']");

    public static final Target PRODUCTS_TABLE = Target.the("Products table in cart")
            .locatedBy("(//tr[@class='product-item'])[1]");
}
