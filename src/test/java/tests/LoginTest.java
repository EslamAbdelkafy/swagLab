package tests;

import Pages.LoginPage;
import base.BaseTests;
import com.google.gson.JsonObject;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.DataDriven;

public class LoginTest extends BaseTests {
    private LoginPage loginPage;

    private final String dataPath = "src/test/resources/testData.json";

    @Test(priority = 1)
    public void verifySuccessfulLogin()
    {
        JsonObject data = DataDriven.jsonReader(dataPath);
        JsonObject valid = data.getAsJsonObject("valid");
        String username = valid.get("username").getAsString();
        String password = valid.get("password").getAsString();
        loginPage = new LoginPage(driver);
        loginPage.login(username, password);







    }

@Test(priority = 2)
public void verifyInvalidLogin() {
    goLoginPage();

    JsonObject data = DataDriven.jsonReader(dataPath);
    JsonObject invalid = data.getAsJsonObject("invalid");

    String username = invalid.get("username").getAsString();
    String password = invalid.get("password").getAsString();

    loginPage = new LoginPage(driver);
    loginPage.login(username, password);

    var err = loginPage.getErrorMessage();

    Assert.assertTrue(err.contains("Epic sadface: Username and password do not match any user in this service"),
            "Error message not displayed as expected. Actual: " + err
    );
}
@Test(priority = 3)
public void verifyLoginWithoutPassword() {

    goLoginPage();

    JsonObject data = DataDriven.jsonReader(dataPath);
    JsonObject noPass = data.getAsJsonObject("noPassword");
    String username = noPass.get("username").getAsString();

    LoginPage loginPage = new LoginPage(driver);
    loginPage.enterUsername(username);
    loginPage.enterPassword(""); // empty
    loginPage.clickLoginButton();

    String err = loginPage.getErrorMessage();
    Assert.assertTrue(err.toLowerCase().contains("password is required")
                    || err.toLowerCase().contains("password is required"),
            "Expected error message to contain 'Password is required'. Actual: " + err);
}
}


