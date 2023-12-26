package test.Steps;
import Infrastructure.DriverSetup;
import Infrastructure.WrapApiResponse;
import Utils.DateTimeFormat;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import logic.*;
import org.junit.After;
import org.junit.Assert;
import io.cucumber.datatable.DataTable;
import org.junit.Before;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static logic.ApiCalls.emptyCart;
public class TestCart {
    static HashMap<String,String> items;
    static DriverSetup driverSetup;
    static CartMenu cartMenu;

    //api values
    static ApiCalls apiCalls;
    static WrapApiResponse<ApiResponse> result;
    @BeforeAll
    public static void setUP() throws InterruptedException, IOException {
        driverSetup = new DriverSetup();
        driverSetup.setupDriver("chrome");
        driverSetup.getDriver().get("https://www.rami-levy.co.il/he");
        MainPage mainPage = new MainPage(driverSetup.getDriver());
        mainPage.flowPersonalArea("ashraf.egbaria@gmail.com","Ashrafadel152");
        cartMenu = new CartMenu(driverSetup.getDriver());
        items = new HashMap<>();

        // init api
        apiCalls=new ApiCalls();
        result=null;
    }
    @AfterAll
    public static void tearDown() throws IOException {
        ItemBodyRequest jsonbody=new ItemBodyRequest("331",0,DateTimeFormat.getCurrentDateTime(),new HashMap<String,String>(),null);
        emptyCart(jsonbody.toString());
    }
    @When("Add To Cart Item")
    public void addItem(DataTable dataTable) throws IOException, InterruptedException {
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
        System.out.println(jsonBody);
        result=ApiCalls.addNewProduct(jsonBody.toString());
        System.out.println(result);
    }
    @Then("Check The quantity")
    public static void checkTheQuantity() throws InterruptedException {
        cartMenu.init();
        int sumQuantity = 0;
        for(Map.Entry<String, String> entry : items.entrySet()){
            float floatValue =  Float.parseFloat(entry.getValue());
            sumQuantity+= (int) floatValue ;
        }


        Assert.assertEquals(sumQuantity,cartMenu.countItems());
    }
    @Then("Empty The Cart and Check The Quantity Zero")
    public void checkQuantityToZer() throws IOException, InterruptedException {
        ItemBodyRequest jsonbody=new ItemBodyRequest("331",0,DateTimeFormat.getCurrentDateTime(),new HashMap<String,String>(),null);
        emptyCart(jsonbody.toString());
        Thread.sleep(1200);
        driverSetup.getDriver().navigate().refresh();
        Assert.assertEquals(0,cartMenu.emptyCart());
    }
}