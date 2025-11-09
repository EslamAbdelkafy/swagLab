package tests;

import Pages.LoginPage;
import base.BaseTests;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class LoginTest extends BaseTests {
    private LoginPage loginPage;
    String username = "standard_user";
    String password = "secret_sauce";

   @Test
    public void loginForm()
     {
            loginPage = new LoginPage(driver);
            loginPage.enterUsername(username)
                  .enterPassword(password)
                  .clickLoginButton();
     }
}
