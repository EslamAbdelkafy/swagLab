package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.openqa.selenium.By.cssSelector;


public class LoginPage {
    private WebDriver driver;

    @FindBy(id = "user-name")
    private WebElement username;
    @FindBy(id = "password")
    private WebElement password;
    @FindBy(id = "login-button")
    private WebElement loginButton;
    @FindBy (css = "h3[data-test='error']")
    private WebElement errorMsgContainer;



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

    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
    }

    public String getErrorMessage() {
        try {
            return errorMsgContainer.getText().trim();
        } catch (Exception e) {
            return "";
        }
    }

}
