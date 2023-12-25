package logic;
import Infrastructure.BasePage;
import Infrastructure.DriverSetup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class MainPage extends BasePage {
    private final String LOGIN = "//*[@id=\"login-user\"]/div[2]";
    private final String EMAILID = "email";
    private final String PASSWORDID = "password";
    private final String ENTER_BUTTON_CSSS_ELECTOR = "button[aria-label='כניסה']";
    private WebElement login;
    //login block
    private WebElement email;
    private WebElement password;
    private WebElement enterButton;
    public MainPage(WebDriver driver) {
        super(driver);
        initPage();
        flowLoginBlock();
        initLoginBlock();
    }
    private void initPage(){
        login = driver.findElement(By.xpath(LOGIN));
    }
    private void flowLoginBlock(){
        login.click();
    }
    private void initLoginBlock(){
        email = driver.findElement(By.id(EMAILID));
        password = driver.findElement(By.id(PASSWORDID));
        enterButton = driver.findElement(By.cssSelector(ENTER_BUTTON_CSSS_ELECTOR));
    }
    public void fillEmail(String email){
        this.email.sendKeys(email);
    }
    public void fillPassword(String password){
        this.password.sendKeys(password);
    }
    public void clickEnterButton(){
        enterButton.click();
    }
    public void flowPersonalArea(String email , String password) throws InterruptedException {
        this.email.sendKeys(email);
        this.password.sendKeys(password);
        Thread.sleep(300);
        enterButton.click();
    }
}