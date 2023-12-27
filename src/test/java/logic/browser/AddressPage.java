package logic.browser;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.List;

public class AddressPage {
    private static final By LIST_OF_ADDRESS = By.xpath("//div[@class='address-item']");

    private final String ADDRESS_DETAILS="(//div[@class='overflow-ellipsis blue m-text position-absolute rl-boxshadow top-10 bg-white px-2 border-radius-15'])[last()]/span";

    private final List<WebElement> listOfAddress;

    private List<WebElement> addressDetails;
    private WebDriver driver;
    public AddressPage(WebDriver driver) {
        this.driver = driver;
        this.listOfAddress = this.driver.findElements(LIST_OF_ADDRESS);
        this.addressDetails = this.driver.findElements(By.xpath(ADDRESS_DETAILS));

    }

    public boolean doesAddressExist() {
        return listOfAddress.isEmpty();
    }
    public boolean addressListContainsCity(String city) {
        List<String> listOfAddressDetails = new ArrayList<>();
        for (WebElement element : addressDetails) {
            listOfAddressDetails.add(element.getText());
        }
        return listOfAddressDetails.contains(city);
    }
}