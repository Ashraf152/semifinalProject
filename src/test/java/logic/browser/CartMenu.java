package logic.browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;
public class CartMenu {
    private final  String CART_BLOCK = "ul[data-v-1980ce6d]";
    private static final String EMPTY_BLOCK = "div[data-v-0a965fa6][data-v-1980ce6d]";
    private static WebDriver driver;
    static WebElement emptyList;
    WebElement list;
    private List<WebElement> liElements;
    public CartMenu(WebDriver driver) throws InterruptedException {
        this.driver = driver;
    }
    private void init() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 12);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(CART_BLOCK + " li")));
        list = driver.findElement(By.cssSelector(CART_BLOCK));
        liElements = list.findElements(By.tagName("li"));
        liElements.remove(liElements.size()-1);
    }
    public int countItems() throws InterruptedException {
        init();
        int count = 0;
        for(WebElement e : liElements){
            if(!e.getAttribute("innerHTML").contains("חסר במלאי")){
                WebElement spanElement = e.findElement(By.cssSelector("span[data-v-4a6ad7a6='']"));
                count += Integer.valueOf(spanElement.getText());
            }
        }
        return count;
    }
    public  boolean isEmptyCart(){
        WebDriverWait wait = new WebDriverWait(driver, 12);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(EMPTY_BLOCK)));
        emptyList = driver.findElement(By.cssSelector(EMPTY_BLOCK));
        boolean noUl = emptyList.findElements(By.tagName("ul")).isEmpty();
        boolean noLi = emptyList.findElements(By.tagName("li")).isEmpty();
        if (noUl && noLi){return true;}
        else {return false;}

    }
}

