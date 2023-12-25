package logic;
import Infrastructure.WrapApiResponse;
import Utils.DateTimeFormat;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import static Utils.ApiResponseParser.getJsonData;
import static logic.ApiCalls.emptyCart;

public class CartMenu {
    private final  String CART_BLOCK = "ul[data-v-1980ce6d]";
    private WebDriver driver;
    WebElement list;
    private List<WebElement> liElements;
    public CartMenu(WebDriver driver) throws InterruptedException {
        this.driver = driver;
        init();
    }
    private void init() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 12);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(CART_BLOCK + " li")));
        list = driver.findElement(By.cssSelector(CART_BLOCK));
        liElements = list.findElements(By.tagName("li"));
        liElements.remove(liElements.size()-1);
    }
    public int countItems(){
        int count = 0;
        for(WebElement e : liElements){
            if(!e.getAttribute("innerHTML").contains("חסר במלאי")){
                WebElement spanElement = e.findElement(By.cssSelector("span[data-v-4a6ad7a6='']"));
                count += Integer.valueOf(spanElement.getText());
            }
        }
        return count;
    }

    public static void main(String[] args) throws InterruptedException, IOException {
//        ApiCalls apiCalls=new ApiCalls();
//        WrapApiResponse<ApiResponse>result=null;
//        String store="331";
//        int inClub=0;
//        String supplyAt= DateTimeFormat.getCurrentDateTime();
//        HashMap<String,String> items= new HashMap<>();
//        items.put("310480","1.00");
//        items.put("310482","2.00");
//        items.put("164854","3.00");
//        ItemBodyRequest jsonBody=new ItemBodyRequest(store,inClub,supplyAt,items,null);
//        System.out.println(jsonBody);
//        result=ApiCalls.addNewProduct(jsonBody.toString());
//        System.out.println(result);

        System.setProperty("webdriver.chrome.driver", "/Users/waseemabusobe/Desktop/chromedriver");
        // Create a new instance of the ChromeDriver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        // Navigate to the page containing the HTML snippet
        driver.get("https://www.rami-levy.co.il/he");
        MainPage mainPage = new MainPage(driver);
        mainPage.flowPersonalArea("ashraf.egbaria@gmail.com","Ashrafadel152");
        CartMenu cartMenu = new CartMenu(driver);
        System.out.println(cartMenu.countItems());

//        ItemBodyRequest jsonbody=new ItemBodyRequest("331",0,DateTimeFormat.getCurrentDateTime(),new HashMap<String,String>(),null);
//        emptyCart(jsonbody.toString());
        //ashraf.egbaria@gmail.com
        //Ashrafadel152
    }


}

