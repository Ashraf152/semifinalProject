package test.Steps;

import Infrastructure.DriverSetup;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import logic.browser.Searching;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class SearchingStep {
    private WebDriver driver;
    DriverSetup driverSetup;
    private String searchQuery = "";

    @Given("I am navigated to {string}")
    public void ramiLevyPage(String url) {
        driverSetup = new DriverSetup();
        driverSetup.setupDriver("chrome");
        driverSetup.navigateToURL(url);
    }

    @When("I search for {string}")
    public void iSearchForProduct(String searchWord) {
        Searching searching = new Searching(driverSetup.getDriver());
        searching.clickOnSearchButton(searchWord);
    }

    @And("I click enter")
    public void iClickEnter() {
        Searching searching = new Searching(driverSetup.getDriver());
        searching.clickEnter();
    }

    @Then("I got sub page with relevant results")
    public void iGotSubPageWithRelevantResults() {
        Assert.assertTrue(Searching.getTittle());
     }
}