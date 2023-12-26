package logic;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Searching {
    private static final String tittle ="/html/head/title";
    private final String SEARCHFIELD = "destination";
    private WebElement searchInput;
    private static WebDriver driver;
    private WebDriverWait wait;

    public Searching(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 5);
        driver.manage().window().maximize();
        initPage();
    }

    private void initPage() {
        this.searchInput = wait.until(ExpectedConditions.elementToBeClickable(By.id(SEARCHFIELD)));
    }

    public void clickOnSearchButton(String searchQuery) {
        searchInput.click();
        searchInput.sendKeys(searchQuery);
    }

    public void clickEnter() {
        searchInput.sendKeys(Keys.ENTER);
    }
    public static boolean getTittle(){
        WebElement tittleElement = driver.findElement(By.xpath(tittle));
        System.out.println("tittle "+tittleElement.getText());
        return (tittleElement.getText().contains("חיפוש מוצרים באתר - רמי לוי אונליין"));
    }
}