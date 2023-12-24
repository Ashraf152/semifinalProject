package test.steps;

import Infrastructure.DriverSetup;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginTest {
    DriverSetup driverSetup;
    @Before
    public void setup(){
        driverSetup=new DriverSetup();
        driverSetup.setupDriver("chrome");
    }
    @Given("I navigated to {string}")
    public void ramiLeviPage(String url){
        driverSetup.navigateToURL(url);
    }


    @When("I click on profile button")
    public void iClickOnProfileButton() {
        
    }

    @And("I enter {string}")
    public void iEnterMyEmail() {
        
    }

    @And("I click on login Button")
    public void iClickOnLoginButton() {
        
    }

    @Then("The main page of the website is appear and My account has been login")
    public void theMainPageOfTheWebsiteIsAppearAndMyAccountHasBeenLogin() {
    }
}
