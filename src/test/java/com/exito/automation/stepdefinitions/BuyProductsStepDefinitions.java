package com.exito.automation.stepdefinitions;


import com.exito.automation.exceptions.ExceptionError;
import com.exito.automation.questions.PricesAre;
import com.exito.automation.questions.ProductsAdded;
import com.exito.automation.questions.ProductsAre;
import com.exito.automation.questions.QuantitiesAre;
import com.exito.automation.tasks.BuyProducts;
import com.exito.automation.utils.ReadFiles;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.*;


public class BuyProductsStepDefinitions {
    @Given("user buys products of {string}")
    public void userBuys(String category) {
        theActorInTheSpotlight().attemptsTo(BuyProducts.onExito(ReadFiles.readProduct(category)));
    }

    @When("sees the cart")
    public void seesTheCart() {
        theActorInTheSpotlight().should(seeThat(ProductsAre.inTheCart()).orComplainWith(ExceptionError.class));
        theActorInTheSpotlight().should(seeThat(ProductsAdded.areInTheCart()).orComplainWith(ExceptionError.class));
    }

    @Then("should see the price of the products")
    public void shouldSeeThePriceOfTheProducts() {
        theActorInTheSpotlight().should(seeThat(PricesAre.OkinTheCart()).orComplainWith(ExceptionError.class));
    }

    @And("should see the quantities of the products")
    public void shouldSeeTheQuantities() {
        theActorInTheSpotlight().should(seeThat(QuantitiesAre.OkInTheCart()).orComplainWith(ExceptionError.class));
    }



}
