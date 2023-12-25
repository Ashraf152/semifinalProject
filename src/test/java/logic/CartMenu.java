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
}
