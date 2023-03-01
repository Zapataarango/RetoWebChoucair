package com.exito.automation.tasks;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

import static com.exito.automation.userinterfaces.InicioDeSesionUI.*;

public class CheckTheCart implements Task {

    public static CheckTheCart onExito() {
        return Tasks.instrumented(CheckTheCart.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(BTN_CART)
        );
    }
}
