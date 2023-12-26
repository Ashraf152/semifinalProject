package test.Steps;

import Infrastructure.DriverSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import logic.Login;
import logic.Logout;
import org.junit.Assert;

public class LogoutSteps{
    DriverSetup driverSetup;
    Logout logout;
    @Given("Flow To Personal Area")
    public void setUp() throws InterruptedException {
        driverSetup = new DriverSetup();
        driverSetup.setupDriver("chrome");
        driverSetup.getDriver().get("https://www.rami-levy.co.il/he");
        Login login = new Login(driverSetup.getDriver());
        login.fullLoginProccess();
        Thread.sleep(2000);
    }
    @When("I Click On LogOut")
    public void clickLogout() throws InterruptedException {
        logout = new Logout(driverSetup.getDriver());
        logout.clickLogout();
    }
    @Then("Check LogOut Feature")
    public void checkLogout() throws InterruptedException {
        String expectString = "התחברות";
        Assert.assertEquals(expectString,logout.getUserName());
    }
}
