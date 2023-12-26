package logic;
import Infrastructure.DriverSetup;
import Infrastructure.WrapApiResponse;
import Utils.DateTimeFormat;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
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
    private final String EMPTY_BLOCK = "div[data-v-0a965fa6][data-v-1980ce6d]";
    private WebDriver driver;
    WebElement list;
    WebElement emptyList;
    private List<WebElement> liElements;
    public CartMenu(WebDriver driver) throws InterruptedException {
        this.driver = driver;
    }
    public void init() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 12);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("ul[data-v-1980ce6d]")));
        list = driver.findElement(By.cssSelector(CART_BLOCK));
        liElements = list.findElements(By.tagName("li"));
        liElements.remove(liElements.size()-1);
    }
    public int countItems() throws InterruptedException {
        int count = 0;
        for(WebElement e : liElements){
            if(!e.getAttribute("innerHTML").contains("חסר במלאי")){
                WebElement spanElement = e.findElement(By.cssSelector("span[data-v-4a6ad7a6='']"));
                count += Integer.valueOf(spanElement.getText());
            }
        }
        return count;
    }
    public int emptyCart(){
        WebDriverWait wait = new WebDriverWait(driver, 12);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(EMPTY_BLOCK)));
        emptyList = driver.findElement(By.cssSelector(EMPTY_BLOCK));
        boolean noUl = emptyList.findElements(By.tagName("ul")).isEmpty();
        boolean noLi = emptyList.findElements(By.tagName("li")).isEmpty();
        if (noUl && noLi){return 0;}
        else {return -1;}
    }

    public static void main(String[] args) throws InterruptedException {
        DriverSetup driverSetup = new DriverSetup();
        driverSetup = new DriverSetup();
        driverSetup.setupDriver("chrome");
        driverSetup.getDriver().get("https://www.rami-levy.co.il/he");
        Login login = new Login(driverSetup.getDriver());
        login.fullLoginProccess();
        driverSetup.getDriver().navigate().refresh();
    }
}

