package test.Steps;


import Infrastructure.DriverSetup;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import logic.Header;
import logic.Login;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginSteps {
    DriverSetup driverSetup;
    Login login;
    @Given("I navigated to {string}")
    public void ramiLeviPage(String url) throws InterruptedException {
        driverSetup=new DriverSetup();
        driverSetup.setupDriver("chrome");
        driverSetup.navigateToURL(url);
        login=new Login(driverSetup.getDriver());
    }
    @When("I click on profile button")
    public void iClickOnProfileButton() {

        login.clickOnLoginButton();
    }
    @And("I enter my email {string}")
    public void iEnterMyEmail(String email) {
        login.fillEmail(email);
    }
    @And("I enter my password {string}")
    public void iEnterMyPassword(String password) {
        login.fillPassword(password);
    }
    @And("I click on login Button")
    public void iClickOnLoginButton() throws InterruptedException {
        Thread.sleep(1200);
        login.clickEnterButton();

    }
    @Then("The main page of the website is appear and My account has been login")
    public void theMainPageOfTheWebsiteIsAppearAndMyAccountHasBeenLogin() throws InterruptedException {
        Thread.sleep(2000);
        String expectedText = "וסים"; // Replace with the expected text
        Header header = new Header(driverSetup.getDriver());
        Assert.assertEquals(expectedText, header.getUserName());
    }
}