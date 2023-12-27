package test.Steps;


import Infrastructure.DriverSetup;
import Utils.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import logic.browser.Login;
import org.junit.Assert;

public class LoginSteps {
    private final TestContext context;
    DriverSetup driverSetup;

    public LoginSteps(TestContext context) {
        this.context = context;
    }


    @Given("I navigated to {string}")
    public void ramiLeviPage(String url){
        driverSetup=new DriverSetup();
        driverSetup.setupDriver("chrome");
        driverSetup.navigateToURL(url);
        context.put("driver",driverSetup.getDriver());
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
    public void iClickOnLoginButton() throws InterruptedException {
        Login login=new Login(driverSetup.getDriver());
        login.clickEnterButton();

    }

    @Then("The main page of the website is appear and My account has been login")
    public void theMainPageOfTheWebsiteIsAppearAndMyAccountHasBeenLogin() {
        Assert.assertTrue(Login.isLogin());
    }
}