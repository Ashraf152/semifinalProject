package logic.browser;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Filter {
    private final String FILTERBUTTON = "//*[@id=\"search\"]/div/div/div[1]/div/div[1]/div/div[1]/div[3]";
    private final String COOSENLABEL = "//*[@id=\"__layout\"]/div/div[1]/div[1]/div[3]/div[3]/div/div[1]/div[2]/div/div[3]";
    private WebElement filterButton;
    private WebDriver driver;
    private WebDriverWait wait;

    public Filter(WebDriver driver) {
        this.driver = driver;
        driver.manage().window().maximize();
        this.wait = new WebDriverWait(driver, 10);
        this.filterButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(FILTERBUTTON)));
    }

    public void clickOnFilterButton() {
        filterButton.click();
    }

    public void clickOnLabel() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(COOSENLABEL)));
        WebElement checkbox = driver.findElement(By.xpath(COOSENLABEL));
        if (!checkbox.isSelected()) {
            checkbox.click();
        }
    }

    public void getResults() {
        filterButton.click();
    }
}