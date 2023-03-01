package com.exito.automation.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.exito.automation.userinterfaces.InicioDeSesionUI.BTN_ADD_QUANTITY;


public class RandomQuantity implements Interaction {


    public static RandomQuantity ofProduct() {
        return Tasks.instrumented(RandomQuantity.class);
    }


    @Override
    public <T extends Actor> void performAs(T actor) {
        Random random = new Random();
        int quantity;
        quantity = random.nextInt(9);

        for (int i = 0; i < quantity; i++) {
            actor.attemptsTo(
                    Wait.seconds(1),
                    Click.on(BTN_ADD_QUANTITY));

        }


        actor.remember("QUANTITIES", quantity);
    }
}
