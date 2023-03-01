package com.exito.automation.questions;

import com.exito.automation.interactions.Wait;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.ensure.Ensure;

import java.util.List;

import static com.exito.automation.userinterfaces.CartUI.LBL_TOTAL_QUANTITY;

public class QuantitiesAre implements Question<Boolean> {

    public static QuantitiesAre OkInTheCart() {
        return new QuantitiesAre();
    }

    @Override
    public Boolean answeredBy(Actor actor) {

        int total=0;

        List<Integer> productsQuantities = actor.recall("PRODUCTS_QUANTITIES");


        for (int i = 0; i < productsQuantities.size(); i++) {
            total+= productsQuantities.get(i)+1;
        }
        actor.attemptsTo(
                Wait.seconds(1),
                Ensure.that(LBL_TOTAL_QUANTITY.resolveFor(actor).getText()).contains(Integer.toString(total))
        );

        return true;
    }
}
