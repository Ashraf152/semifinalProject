package logic.browser;
import logic.browser.Header;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login {
    private final String EMAILID = "email";
    private final String PASSWORDID = "password";
    private final String ENTER_BUTTON_CSSS_ELECTOR = "button[aria-label='כניסה']";
    private static final String IS_LOGIN = "//*[@id=\"login-user\"]/div/div/div[2]/div/span";
    private static WebDriver driver;
    private WebElement email;
    private WebElement password;
    private WebElement enterButton;
    private static WebElement isLoginElement;
    WebDriverWait wait;

    private Header header;

    public Login(WebDriver driver) {
        this.driver = driver;
        header = new Header(driver);
        wait = new WebDriverWait(this.driver, 3);
    }

    public void clickOnLoginButton() {
        header.clickOnLoginButton();
    }

    public void fillEmail(String email) {
        this.email = driver.findElement(By.id(EMAILID));
        this.email.sendKeys(email);
    }

    public void fillPassword(String password) {
        this.password = driver.findElement(By.id(PASSWORDID));
        this.password.sendKeys(password);
    }

    public void clickEnterButton() {
        this.enterButton = driver.findElement(By.cssSelector(ENTER_BUTTON_CSSS_ELECTOR));
        this.enterButton.click();
    }

    public void fullLoginProccess() {
        this.clickOnLoginButton();
        this.fillEmail("ashraf.egbaria@gmail.com");
        this.fillPassword("Ashrafadel152");
        this.clickEnterButton();

    }

    public static boolean isLogin() {
        driver.manage().window().fullscreen();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        isLoginElement= wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(IS_LOGIN)));
        if (isLoginElement != null) {
            return wait.until(ExpectedConditions.textToBePresentInElement(isLoginElement, "Ashraf"));
        } else {
            return false;
        }
    }
}