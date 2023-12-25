package Infrastructure;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverSetup {
    private static final String driverPATH = "/Users/waseemabusobe/Desktop/chromedriver";
    private WebDriver driver;
    public void setupDriver(String driverName) {
        this.driver = switch (driverName.toLowerCase()) {
            case "chrome" -> {
                System.setProperty("webdriver.chrome.driver", driverPATH);
                yield new ChromeDriver();
            }
            case "firefox" -> {
                System.setProperty("webdriver.gecko.driver", "path/to/geckodriver");
                yield new FirefoxDriver();
            }
            default -> throw new IllegalArgumentException("Invalid driver name: " + driverName);
        };
    }
    public WebDriver getDriver() {
        return this.driver;
    }
    public void closeDriver() {
        driver.close();
        driver.quit();
    }
    public void navigateToURL(String URL) {
        driver.get(URL);
    }
    public String getURL(){
        return driver.getCurrentUrl();
    }

}