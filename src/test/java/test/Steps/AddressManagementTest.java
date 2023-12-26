package test.Steps;

import Infrastructure.DriverSetup;
import Infrastructure.WrapApiResponse;
import Utils.TestContext;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import logic.*;
import org.openqa.selenium.WebDriver;
import org.testng.AssertJUnit;

import java.io.IOException;
import java.util.Optional;

import static Utils.ApiResponseParser.getJsonData;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AddressManagementTest {
    private final TestContext context;
    private DriverSetup driverSetup;
    private Login login;
    private WebDriver driver;
    private ApiCalls apiCalls;
    public AddressManagementTest(TestContext context) {
        this.context = context;
    }
    @Before
    public void setup(){
        driverSetup=new DriverSetup();
        driverSetup.setupDriver("chrome");
        driverSetup.navigateToURL("https://www.rami-levy.co.il/he/");
        driver=driverSetup.getDriver();
        login=new Login(driver);
        login.fullLoginProccess();
    }
    @Given("User added new address to his account")
    public void addNewAddress() throws IOException {
        apiCalls=new ApiCalls();
        WrapApiResponse<AdressApiResponse> result;
        AdressBodyRequest addressBodyRequest=new AdressBodyRequest(null,2779,"עכו","12","12","12","12",null,"12");
        result=ApiCalls.addNewAdress(addressBodyRequest.toString());
        result.setData(getJsonData(result.getData()));
        Object[] arr = result.getData().getData().getAllAddresses().keySet().toArray();
        String newAddressCity = result.getData().getData().getNewAddress().getCity();
        int id=result.getData().getData().getNewAddress().getId();
        context.put("IdAddress",id);
        context.put("newAddressCity",newAddressCity);
        System.out.println(id+" "+newAddressCity);
    }

    @When("User click on address management")
    public void userClickOnAddressManagement() {
        MainPage mainPage=new MainPage(driver);
        mainPage.clickOnProfileDropDown();
        mainPage.clickOnAddressManagement();
    }

    @Then("User see the new address been updated")
    public void userSeeTheNewAddressBeenUpdated() {
        AddressPage addresspage=new AddressPage(driver);
        assertTrue(addresspage.addressListContainsCity(context.get("newAddressCity")));
    }

    @When("I delete that address")
    public void iDeleteThatAddress() throws IOException {
        System.out.println("id address -> "+(context.get("IdAddress")));
        ApiCalls.deleteaddress(context.get("IdAddress").toString());
    }

    @Then("The address should be removed")
    public void theAddressShouldBeRemoved() {
        AddressPage addressPage = new AddressPage(driverSetup.getDriver());
        assertTrue(addressPage.doesAddressExist());
    }
}