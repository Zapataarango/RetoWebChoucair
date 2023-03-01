package com.exito.automation.tasks;

import com.exito.automation.interactions.RandomQuantity;
import com.exito.automation.interactions.Wait;
import com.exito.automation.models.Modelo;
import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.ArrayList;
import java.util.List;

import static com.exito.automation.userinterfaces.InicioDeSesionUI.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

@AllArgsConstructor
public class BuyProducts implements Task {
    private Modelo modelo;

    public static BuyProducts onExito(Modelo modelo) {
        return Tasks.instrumented(BuyProducts.class, modelo);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        int ProductsQuantity = 5;
        List<String> productsList = new ArrayList<>();
        List<String> productsPrices = new ArrayList<>();
        List<Integer> productsQuantities = new ArrayList<>();
        for (int i = 1; i <= ProductsQuantity; i++) {
            actor.attemptsTo(
                    Wait.seconds(3),
                    Click.on(BTN_SIDE_MENU),
                    Click.on(BTN_CATEGORY.of(modelo.getCategory())),
                    WaitUntil.the(BTN_SUBCATEGORY.of(modelo.getSubcategory()), isVisible()).forNoMoreThan(2).seconds(),
                    Click.on(BTN_SUBCATEGORY.of(modelo.getSubcategory())),
                    Wait.seconds(8),
                    Click.on(LST_PRODUCTS.of(Integer.toString(i))),
                    Wait.seconds(8),
                    Click.on(BTN_ADD_TO_CART));
            productsPrices.add(LBL_PRODUCT_PRICE.resolveFor(actor).getText());
            productsList.add(LBL_PRODUCT_NAME.resolveFor(actor).getText());
            actor.attemptsTo(
                    RandomQuantity.ofProduct(),
                    Wait.seconds(1));
            productsQuantities.add(actor.recall("QUANTITIES"));
        }
        actor.attemptsTo(Click.on(BTN_CART),
                Wait.seconds(20));
        actor.remember("PRODUCTS_LIST", productsList);
        actor.remember("PRODUCTS_PRICES", productsPrices);
        actor.remember("PRODUCTS_QUANTITIES", productsQuantities);
        actor.remember("PRODUCTS_ADDED", ProductsQuantity);

    }
}
