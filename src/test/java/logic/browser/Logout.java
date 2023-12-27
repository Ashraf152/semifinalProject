package logic.browser;

import logic.browser.Header;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Logout {
    WebDriver webDriver;
    WebElement logout;
    Header header;
    public Logout(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
    public void clickLogout() throws InterruptedException {
        Header header = new Header(this.webDriver);
        header.clickOnLoginButton();
        Thread.sleep(300);
        logout = webDriver.findElement(By.xpath("//*[@id=\"__layout\"]/div/div[1]/div[1]/div[3]/div[3]/div/div[2]/div[4]/div/div[2]/div/div/div[7]/div"));
        logout.click();
    }

    public String getUserName() throws InterruptedException {
        header = new Header(webDriver);
        return header.getUserName();
    }



}