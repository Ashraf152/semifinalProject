package test.Steps;

import Infrastructure.DriverSetup;
import Infrastructure.WrapApiResponse;
import Utils.TestContext;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import logic.*;
import org.openqa.selenium.WebDriver;
import java.io.IOException;
import static Utils.ApiResponseParser.getJsonData;
import static org.junit.Assert.assertTrue;

public class AddressManagementSteps {
    private final TestContext context;
    private static WebDriver driver;
    private static ApiCalls apiCalls;
    public AddressManagementSteps(TestContext context) {
        this.context = context;
    }

    @And("User added new address to his account")
    public void addNewAddress() throws IOException {
        driver=context.get("driver");
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
        MainPage mainPage=new MainPage(driver);
        mainPage.clickOnProfileDropDown();
        mainPage.clickOnAddressManagement();
        ApiCalls.deleteaddress(context.get("IdAddress").toString());
    }

    @Then("The address should be removed")
    public void theAddressShouldBeRemoved() {
        AddressPage addressPage=new AddressPage(driver);
        assertTrue(addressPage.doesAddressExist());
    }
}