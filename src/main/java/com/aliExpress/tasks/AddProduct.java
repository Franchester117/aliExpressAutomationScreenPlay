package com.aliExpress.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.aliExpress.userInterfaces.ProductDetail.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class AddProduct implements Task {

    private String amount;

    public AddProduct(String amount) {
        this.amount = amount;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(COLOR_PRODUCT),
                Enter.theValue(this.amount).into(AMOUNT_PRODUCT_INPUT),
                WaitUntil.the(ADD_TO_CART_BUTTON, WebElementStateMatchers.isEnabled()).forNoMoreThan(10).seconds(),
                Click.on(ADD_TO_CART_BUTTON),
                Click.on(SEE_CART_BUTTON)
        );
    }

    public static AddProduct addProductWithAmount(String amount){
        return instrumented(AddProduct.class, amount);
    }
}
