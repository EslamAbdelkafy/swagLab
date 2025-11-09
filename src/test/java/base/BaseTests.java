package base;

import Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class BaseTests {
    protected WebDriver driver;
    protected LoginPage LoginPage;

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
    }
    @BeforeMethod
    public void goLoginPage() {
        LoginPage = new LoginPage(driver);
        driver.get("https://www.saucedemo.com/");
    }
}