package test.steps;

import Infrastructure.DriverSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class UpdatePhoneNumber {
    WebDriver driver;
    private DriverSetup driverSetup;


    @Given("User in his private area {string}")
    public void userInHisPrivateArea(String url) {

    }
    @When("User update his phone number")
    public void userUpdateHisPhoneNumber() {

    }
    @Then("New phone number shown to the user")
    public void newPhoneNumberShownToTheUser() {
    }


}
