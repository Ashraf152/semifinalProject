package logic;

import Infrastructure.BasePage;
import org.openqa.selenium.WebDriver;

public class MainPage extends BasePage {
    private Header header;
    public MainPage(WebDriver driver) {
        super(driver);
        header=new Header(driver);
    }
    public void clickOnProfileDropDown()  {
        header.clickOnProfileDropDown();
    }
    public void clickOnAddressManagement(){
        header.clickOnAddressManagement();
    }
}