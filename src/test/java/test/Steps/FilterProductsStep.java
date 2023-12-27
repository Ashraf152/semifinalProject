package test.Steps;

import Infrastructure.DriverSetup;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import logic.browser.Filter;

public class FilterProductsStep {

    DriverSetup driverSetup;

    @Given("I am navigate to {string}")
    public void ramiLevyPage(String url) {
        driverSetup = new DriverSetup();
        driverSetup.setupDriver("chrome");
        driverSetup.navigateToURL(url);
    }

    @When("Click on the “Filter” button.")
    public void clickOnTheFilterButton() {
        Filter filter = new Filter(driverSetup.getDriver());
        filter.clickOnFilterButton();
    }

    @And("Click on Slim delis brand")
    public void clickOnBrandLabel() {
        Filter filter = new Filter(driverSetup.getDriver());
        filter.clickOnLabel();
    }

    @Then("I got relevant results")
    public void iGotSubPageWithFResults() {
        Filter filter = new Filter(driverSetup.getDriver());
        filter.getResults();
    }
}