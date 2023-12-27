package logic.browser;

import Infrastructure.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class SortCategory extends BasePage {
    private final String  FILTER_BUTTON= "//div[@class='d-flex align-items-center bg-gray-300- border-radius-10 cursor-pointer m-1']";
    private final String SORT_BUTTON="//button[@class='sort cursor-pointer focus-item border-radius-10 border-0 bg-white w-100 py-3- text-left d-flex align-items-center blue-n']";
    private final String FIRSTCATEGORY="(//div[@class='focus-item online-catalog-wrap pb-3 pb-lg-1 d-flex flex-wrap align-content-end'])[1]//span[@class='position-relative currency-wrap overflow-ellipsis lm-text currency-product']";
    private final String OPTION="//button[@class='focus-item btn-acc d-block blue w-100 select-title text-left px-2' and span[text()='מהזול ליקר']]";

    private WebElement filterButton;
    private WebElement sortButton;
    private WebElement option;
    private List<WebElement> itemsList;


    public SortCategory(WebDriver driver) {
        super(driver);
    }
    public void clickOnFilterButton(){
        this.filterButton = driver.findElement(By.xpath(FILTER_BUTTON));
        this.filterButton.click();
    }
    public void clickSortButton(){
        this.sortButton = driver.findElement(By.xpath(SORT_BUTTON));
        this.sortButton.click();
        this.option = driver.findElement(By.xpath(OPTION));
        this.option.click();
    }
    public List<Double> sortList(){
        this.itemsList = driver.findElements(By.xpath(FIRSTCATEGORY));
        List<Double> prices = new ArrayList<>();
        for (WebElement priceElement : itemsList) {
            String priceText = priceElement.getText();
            priceText = priceText.replaceAll("[^0-9.]", "");
            if (!priceText.isEmpty()) {
                prices.add(Double.parseDouble(priceText));
            }
        }
        return prices;
    }

    public  boolean isSorted() {
        List<Double> prices=sortList();
        for (int i = 0; i < prices.size() - 1; i++) {
            if (prices.get(i) > prices.get(i + 1)) {
                return false;
            }
        }
        return true;
    }
}
