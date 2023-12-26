package test;

import Infrastructure.DriverSetup;
import io.cucumber.java.Before;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "test.steps",
        plugin = {"io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm"}
)
public class RunCucumberTest {
    private static WebDriver driver;
    private static DriverSetup driverSetup;

    @Before
    public void setup() {
        driverSetup = new DriverSetup();
        driverSetup.setupDriver("chrome");
        driverSetup.navigateToURL("https://www.rami-levy.co.il/he/");
        driver = driverSetup.getDriver();
    }

    public static WebDriver getDriver() {
        return driver;
    }
}

