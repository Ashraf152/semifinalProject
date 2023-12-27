package logic.browser;

import Infrastructure.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Header extends BasePage {
    private final String USER_BUTTON = "login-user";
    private WebElement userButton;
    public Header(WebDriver driver) {
        super(driver);
        this.userButton = driver.findElement(By.id(USER_BUTTON));
    }
    public void clickOnLoginButton(){
        this.userButton.click();
    }
    public String getUserName() {
        return userButton.getText();
    }
}