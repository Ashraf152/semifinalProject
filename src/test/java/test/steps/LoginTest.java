package test.steps;

import Infrastructure.DriverSetup;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import logic.Login;

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
        Login login=new Login(driverSetup.getDriver());
        login.clickOnLoginButton();
    }

    @And("I enter my email {string}")
    public void iEnterMyEmail(String email) {
        Login login=new Login(driverSetup.getDriver());
        login.fillEmail(email);
    }
    @And("I enter my password {string}")
    public void iEnterMyPassword(String password) {
        Login login=new Login(driverSetup.getDriver());
        login.fillPassword(password);
    }

    @And("I click on login Button")
    public void iClickOnLoginButton() {
        Login login=new Login(driverSetup.getDriver());
        login.clickEnterButton();
    }

    @Then("The main page of the website is appear and My account has been login")
    public void theMainPageOfTheWebsiteIsAppearAndMyAccountHasBeenLogin() {
    }
}
