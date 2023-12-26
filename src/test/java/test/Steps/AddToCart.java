package test.Steps;
import Infrastructure.DriverSetup;
import Infrastructure.WrapApiResponse;
import Utils.DateTimeFormat;
import Utils.TestContext;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import logic.*;
import org.junit.Assert;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AddToCart {
    static HashMap<String,String> items;
    private static DriverSetup driverSetup;
    private static Login login;
    private static WebDriver driver;
    private static ApiCalls apiCalls;
    static WrapApiResponse<ApiResponse> result;
    static CartMenu cartMenu;

    @Given("setUp")
    public static void setup() throws InterruptedException {
        driverSetup=new DriverSetup();
        driverSetup.setupDriver("chrome");
        driverSetup.navigateToURL("https://www.rami-levy.co.il/he/");
        driver=driverSetup.getDriver();
        login=new Login(driver);
        login.fullLoginProccess();
        items = new HashMap<>();
        apiCalls=new ApiCalls();
        result=null;
    }

    @AfterAll
    public static void tearDown(){
        driverSetup.closeDriver();
        items=null;
        apiCalls=null;
        result=null;
    }

    @When("Add To Cart Item")
    public void addItem(DataTable dataTable) throws IOException {
        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : rows) {
            String item = row.get("item");
            String quantity = row.get("quantity");
            items.put(item, quantity);
        }
        String store="331";
        int inClub=0;
        String supplyAt= DateTimeFormat.getCurrentDateTime();
        ItemBodyRequest jsonBody=new ItemBodyRequest(store,inClub,supplyAt,items,null);
        result=ApiCalls.addNewProduct(jsonBody.toString());
    }
    @Then("Check The quantity")
    public static void checkTheQuantity() throws InterruptedException {
        cartMenu = new CartMenu(driver);
        int sumQuantity = 0;
        for(Map.Entry<String, String> entry : items.entrySet()){
            float floatValue =  Float.parseFloat(entry.getValue());
            sumQuantity+= (int) floatValue ;
        }
        Assert.assertEquals(sumQuantity,cartMenu.countItems());
    }

    @When("Remove all the item in the cart")
    public void removeAllTheItemInTheCaert() throws IOException, InterruptedException {
        ItemBodyRequest jsonbody=new ItemBodyRequest("331",0,DateTimeFormat.getCurrentDateTime(),new HashMap<String,String>(),null);
        ApiCalls.emptyCart(jsonbody.toString());
        Thread.sleep(500);
        driverSetup.getDriver().navigate().refresh();
        Thread.sleep(1200);
    }

    @Then("Check if the cart is empty")
    public void checkIfTheCartIsEmpty() throws InterruptedException {
        cartMenu = new CartMenu(driver);
        Assert.assertTrue(cartMenu.isEmptyCart());
    }
}