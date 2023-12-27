package test.Steps;

import Utils.TestContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import logic.browser.Logout;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class LogoutSteps{
    private final TestContext context;
    WebDriver driver;
    Logout logout;

    public LogoutSteps(TestContext context) {
        this.context = context;
        driver=context.get("driver");
    }
    @When("I Click On LogOut")
    public void clickLogout() throws InterruptedException {
        Thread.sleep(5000);
        logout = new Logout(driver);
        logout.clickLogout();
    }
    @Then("Check LogOut Feature")
    public void checkLogout() throws InterruptedException {
        String expectString = "התחברות";
        Assert.assertEquals(expectString,logout.getUserName());
    }
}