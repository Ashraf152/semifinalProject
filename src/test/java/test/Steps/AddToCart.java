package test.Steps;
import Infrastructure.WrapApiResponse;
import Utils.DateTimeFormat;
import Utils.TestContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import logic.api.ApiCalls;
import logic.api.ApiResponse;
import logic.api.ItemBodyRequest;
import logic.browser.CartMenu;
import org.junit.Assert;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AddToCart {
    static HashMap<String,String> items;
    private final TestContext context;
    private static WebDriver driver;
    private static ApiCalls apiCalls;
    static WrapApiResponse<ApiResponse> result;
    static CartMenu cartMenu;

    public AddToCart(TestContext context) {
        this.context = context;
    }

    @When("Add To Cart Item")
    public void addItem(DataTable dataTable) throws IOException {
        driver=context.get("driver");
        items = new HashMap<>();
        apiCalls=new ApiCalls();
        result=null;
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
    public static void checkTheQuantity() throws InterruptedException, IOException {
        cartMenu = new CartMenu(driver);
        int sumQuantity = 0;
        for(Map.Entry<String, String> entry : items.entrySet()){
            float floatValue =  Float.parseFloat(entry.getValue());
            sumQuantity+= (int) floatValue ;
        }
        Assert.assertEquals(sumQuantity,cartMenu.countItems());
        ItemBodyRequest jsonbody=new ItemBodyRequest("331",0,DateTimeFormat.getCurrentDateTime(),new HashMap<String,String>(),null);
        ApiCalls.emptyCart(jsonbody.toString());
    }

    @When("Remove all the item in the cart")
    public void removeAllTheItemInTheCaert() throws IOException, InterruptedException {
        driver=context.get("driver");
        ItemBodyRequest jsonbody=new ItemBodyRequest("331",0,DateTimeFormat.getCurrentDateTime(),new HashMap<String,String>(),null);
        ApiCalls.emptyCart(jsonbody.toString());
        Thread.sleep(500);
        driver.navigate().refresh();
        Thread.sleep(1200);
    }

    @Then("Check if the cart is empty")
    public void checkIfTheCartIsEmpty() throws InterruptedException {
        cartMenu = new CartMenu(driver);
        Assert.assertTrue(cartMenu.isEmptyCart());
    }
}