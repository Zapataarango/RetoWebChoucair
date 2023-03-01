package com.exito.automation.interactions;

import lombok.AllArgsConstructor;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.List;
import java.util.Random;

import static com.exito.automation.userinterfaces.InicioDeSesionUI.LST_PRODUCTS;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;

@AllArgsConstructor
public class ClickRandom implements Interaction {


    public static ClickRandom product() {
        return Tasks.instrumented(ClickRandom.class);
    }


    @Override
    public <T extends Actor> void performAs(T actor) {
        Random random = new Random();
        List<WebElementFacade> listaBtnProductos = LST_PRODUCTS.resolveAllFor(actor);
        int numRandom = random.nextInt(listaBtnProductos.size());
        actor.attemptsTo(
                WaitUntil.the(LST_PRODUCTS, isEnabled()).forNoMoreThan(10).seconds()
        );
        listaBtnProductos.get(numRandom).click();
    }
}
