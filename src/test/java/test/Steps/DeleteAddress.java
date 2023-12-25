package test.Steps;

import Infrastructure.DriverSetup;
import Utils.TestContext;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import logic.AddressPage;
import logic.ApiCalls;
import logic.MainPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import java.io.IOException;

import static org.testng.AssertJUnit.assertTrue;

public class DeleteAddress {

    private static DriverSetup driverSetup;
    private static ApiCalls apiCalls;


    // when i run AddToCard feature , its also run that BeforeAll!
//    @Before
//    public void setUp() throws InterruptedException {
//        if (driverSetup == null) {
//            driverSetup = new DriverSetup();
//            driverSetup.setupDriver("chrome");
//            driverSetup.getDriver().get("https://www.rami-levy.co.il/he");
//            driverSetup.getDriver().manage().window().maximize();
//            MainPage mainPage = new MainPage(driverSetup.getDriver());
//            mainPage.flowPersonalArea("ashraf.egbaria@gmail.com", "Ashrafadel152");
//            // init api
//            apiCalls = new ApiCalls();
//        }
//    }


//    @AfterAll
//    public static void cleanTeamEnvironment() {
//        if (driverSetup != null) {
//            driverSetup.closeDriver();
//        }
//        apiCalls=null;
//    }



    @When("I delete that address")
    public void iDeleteThatAddress() throws IOException {
        ApiCalls.deleteaddress("663944");
        driverSetup.getDriver().get("https://www.rami-levy.co.il/he/dashboard/addresses");
        driverSetup.getDriver().manage().window().maximize();
    }

    @Then("The address should be removed")
    public void theAddressShouldBeRemoved() {
        AddressPage addressPage = new AddressPage(driverSetup.getDriver());
        assertTrue(addressPage.doesAddressExist());
    }


}
