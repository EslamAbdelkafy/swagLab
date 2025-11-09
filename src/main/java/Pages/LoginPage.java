package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {
    private WebDriver driver;

    @FindBy(id = "user-name")
    private WebElement username;
    @FindBy(id = "password")
    private WebElement password;
    @FindBy(id = "login-button")
    private WebElement loginButton;



    public LoginPage(WebDriver driver)
    {
        this.driver =driver;
        PageFactory.initElements(driver , this);
    }
    public LoginPage enterUsername(String name)
    {
        username.sendKeys(name);
        return this;
    }
    public LoginPage enterPassword(String PasswordInput)
    {
        password.sendKeys(PasswordInput);
        return this;
    }
    public void clickLoginButton()
    {
        loginButton.click();
    }

}
