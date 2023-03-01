package com.exito.automation.questions;

import com.exito.automation.interactions.Wait;
import lombok.AllArgsConstructor;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.ensure.Ensure;

import java.util.List;

import static com.exito.automation.userinterfaces.CartUI.LBL_CART_PRODUCT_NAME;

@AllArgsConstructor
public class ProductsAdded implements Question<Boolean> {

    public static ProductsAdded areInTheCart() {
        return new ProductsAdded();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        int counter = 0;

        List<WebElementFacade> productsListInCart = LBL_CART_PRODUCT_NAME.resolveAllFor(actor);

        for (int i = 0; i < productsListInCart.size(); i++) {
            if (productsListInCart.get(i).isVisible()) {
                counter++;
            } else {
                break;
            }

        }

        actor.attemptsTo(
                Wait.seconds(1),
                Ensure.that(actor.recall("PRODUCTS_ADDED").toString()).isEqualTo(Integer.toString(counter))
        );

        return true;
    }
}
