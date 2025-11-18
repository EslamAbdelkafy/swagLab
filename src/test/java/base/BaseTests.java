package base;

import Pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class BaseTests {
    protected WebDriver driver;
    protected LoginPage LoginPage;


    public void handleBrowserPopup() {
        driver.switchTo().alert().accept();
    }

    @BeforeTest
    public void setUp() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();

        options.addArguments("--disable-save-password-bubble");
        options.addArguments("--disable-password-manager-reauthentication");

        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        options.setExperimentalOption("prefs", prefs);

        driver = new ChromeDriver(options);
//        driver = new ChromeDriver();
    }

    @BeforeMethod
    public void goLoginPage() {
        LoginPage = new LoginPage(driver);
        driver.get("https://www.saucedemo.com/");

    }


    public void tearDown() {
        driver.quit();
    }
}


