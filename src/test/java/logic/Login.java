package logic;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class Login {
    private final String EMAILID = "email";
    private final String PASSWORDID = "password";
    private final String ENTER_BUTTON_CSSS_ELECTOR = "button[aria-label='כניסה']";
    private WebDriver driver;
    private WebElement email;
    private WebElement password;
    private WebElement enterButton;
    private Header header;
    public Login(WebDriver driver) {
        this.driver = driver;
        header=new Header(driver);
    }

    public void clickOnLoginButton(){
        header.clickOnLoginButton();
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
    public void fullLoginProccess() throws InterruptedException {
        this.clickOnLoginButton();
        this.fillEmail("ashraf.egbaria@gmail.com");
        this.fillPassword("Ashrafadel152");
        Thread.sleep(1200);
        this.clickEnterButton();

    }
}