package test.Steps;

import Infrastructure.DriverSetup;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import logic.browser.SortCategory;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertTrue;

public class CategorySortingTest {
    private DriverSetup driverSetup;
    private WebDriver driver;
    @Given("User navigates to Sugar-reduced products page {string}")
    public void userNavigatesToSugarReducedProductsPage(String url) {
        driverSetup=new DriverSetup();
        driverSetup.setupDriver("chrome");
        driver=driverSetup.getDriver();
        driver.get(url);
    }
    @After
    public void tearDown(){
        driverSetup.getDriver().close();
    }

    @When("User click on filter button")
    public void userClickOnFilterButton() throws InterruptedException {
        Thread.sleep(500);
        SortCategory productPage=new SortCategory(driver);
        productPage.clickOnFilterButton();
    }
    @And("User open sorting dropdown and choose from cheap to expensive")
    public void userOpenSortingDropdownAndChooseFromCheapToExpensive() throws InterruptedException {
        Thread.sleep(500);
        SortCategory productPage=new SortCategory(driver);
        productPage.clickSortButton();
    }
    @Then("Products have been sorted")
    public void productsHaveBeenSorted() throws InterruptedException {
        Thread.sleep(500);
        SortCategory productPage=new SortCategory(driver);
        assertTrue(productPage.isSorted());
    }
}