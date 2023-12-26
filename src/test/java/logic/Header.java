package logic;

import Infrastructure.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Header extends BasePage {
    private final String USER_BUTTON = "login-user";
    private final String ADRESS_MANAGMENT="//div[a[@id='dashboard-addresses']]";
    private final String PROFILE_DROPDOWN="//div[@class='position-relative- focus-item']";
    private WebElement profileDropDownButton;
    private WebElement userButton;
    private WebElement addressManagement;


    public Header(WebDriver driver) {
        super(driver);
        this.userButton = driver.findElement(By.id(USER_BUTTON));
    }
    public void clickOnLoginButton(){
        this.userButton.click();
    }
    public void clickOnProfileDropDown() {

        WebDriverWait wait = new WebDriverWait(driver, 10);
        this.profileDropDownButton = wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath(PROFILE_DROPDOWN)));
        //Thread.sleep(5000);
        this.profileDropDownButton.click();

    }
    public void clickOnAddressManagement(){
        this.addressManagement= driver.findElement(By.xpath(ADRESS_MANAGMENT));
        this.addressManagement.click();
    }
    public String getUserName() {
        return userButton.getText();
    }
}