package Infrastructure;


import logic.Login;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class BrowserWrapper {
    private static final String webDriverPath = "C:\\Users\\pc\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe";
    private BasePage currentPage;
    private WebDriver driver;
    public BrowserWrapper() {
        System.setProperty("webdriver.chrome.driver", webDriverPath);
        driver = new ChromeDriver();
    }
    public <T extends BasePage> T createPage(Class<T> pageType){
        return createPage(pageType, null);
    }

    public <T extends BasePage> T createPage(Class<T> pageType, String url){
        try {
            Constructor<T> constructor = pageType.getConstructor(WebDriver.class);
            if(url!=null){
                driver.get(url);
            }
            T page = constructor.newInstance(driver);
            currentPage = page;
            return page;
        } catch (NoSuchMethodException e) {
            throw new RuntimeException("relevant constructor not found", e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public void close(){
        driver.close();
    }

    public <T extends BasePage> T getCurrentPage(){
        return (T)currentPage;
    }


}
