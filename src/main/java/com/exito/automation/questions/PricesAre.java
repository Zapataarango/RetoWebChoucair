package com.exito.automation.questions;

import com.exito.automation.interactions.Wait;
import lombok.AllArgsConstructor;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.ensure.Ensure;

import java.util.List;

import static com.exito.automation.userinterfaces.CartUI.LBL_CART_PRODUCT_NAME;
import static com.exito.automation.userinterfaces.CartUI.LBL_CART_PRODUCT_PRICE;


@AllArgsConstructor
public class PricesAre implements Question<Boolean> {

    public static PricesAre OkinTheCart() {
        return new PricesAre();
    }

    @Override
    public Boolean answeredBy(Actor actor) {

        List<String> productsPricesList = actor.recall("PRODUCTS_PRICES");
        List<WebElementFacade> productsPricesListInCart = LBL_CART_PRODUCT_PRICE.resolveAllFor(actor);

        for (int i = 0; i < productsPricesList.size(); i++) {
            actor.attemptsTo(
                    Wait.seconds(1),
                    Ensure.that(productsPricesList.get(i)).isEqualTo(productsPricesListInCart.get(i).getText())
            );
        }

        return true;
    }
}
