package logic;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class Login {
    private final String LOGIN = "login-user";
    private final String EMAILID = "email";
    private final String PASSWORDID = "password";
    private final String ENTER_BUTTON_CSSS_ELECTOR = "button[aria-label='כניסה']";
    private WebDriver driver;
    private WebElement login;
    private WebElement email;
    private WebElement password;
    private WebElement enterButton;
    public Login(WebDriver driver) {
        this.driver = driver;
        initPage();
    }
    private void initPage(){
        this.login = driver.findElement(By.id(LOGIN));
    }


    public void clickOnLoginButton(){
        this.login.click();
    }
    public void fillEmail(String email){
        this.email = driver.findElement(By.id(EMAILID));
        this.email.sendKeys(email);
    }
    public void fillPassword(String password){
        this.password = driver.findElement(By.id(PASSWORDID));
        this.password.sendKeys(password);
    }
    public void clickEnterButton(){
        this.enterButton = driver.findElement(By.cssSelector(ENTER_BUTTON_CSSS_ELECTOR));
        this.enterButton.click();
    }
    public void flowPersonalArea(String email , String password) throws InterruptedException {
        this.email.sendKeys(email);
        this.password.sendKeys(password);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement searchInput = wait.until(ExpectedConditions
                .elementToBeClickable(enterButton));

    }
}