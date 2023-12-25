package logic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AddressPage {
    private static final By LIST_OF_ADDRESS = By.xpath("//div[@class='address-item']");

    private final List<WebElement> listOfAddress;
    private WebDriver driver;

    public AddressPage(WebDriver driver) {
        this.driver = driver;
        this.listOfAddress = this.driver.findElements(LIST_OF_ADDRESS);
    }

    public boolean doesAddressExist() {
        return listOfAddress.isEmpty();
    }
}
