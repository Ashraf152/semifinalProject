package logic;

import Infrastructure.DriverSetup;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Logout {
    WebDriver webDriver;
    Header header;
    public Logout(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
    public void clickLogout() throws InterruptedException {
        Header header = new Header(this.webDriver);
        header.clickOnLoginButton();
        Thread.sleep(300);
        WebElement logout = webDriver.findElement(By.xpath("//*[@id=\"__layout\"]/div/div[1]/div[1]/div[3]/div[3]/div/div[2]/div[4]/div/div[2]/div/div/div[7]/div"));
        logout.click();
    }

    public String getUserName() throws InterruptedException {
        Header header1 = new Header(webDriver);
        return header1.getUserName();
    }

    public static void main(String[] args) throws InterruptedException {
        DriverSetup driverSetup = new DriverSetup();
        driverSetup.setupDriver("chrome");
        driverSetup.getDriver().get("https://www.rami-levy.co.il/he");
        Login login = new Login(driverSetup.getDriver());
        login.fullLoginProccess();
        Thread.sleep(2000);
        Logout logout = new Logout(driverSetup.getDriver());
        logout.clickLogout();
        String expectString = "התחברות";
        System.out.println(logout.getUserName());
    }

}
