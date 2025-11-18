package Pages;

import org.jetbrains.annotations.TestOnly;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class InventoryPage {
    private WebDriver driver;
    @FindBy (className = "app_logo")
    private WebElement logo;
    @FindBy (className = "shopping_cart_link")
    private WebElement cartIcon;
    @FindBy (className = "inventory_item")
    List<WebElement> inventoryItem;
    @FindBy(className = "social_twitter")
    private WebElement twitterIcon;
    @FindBy(className = "social_facebook")
    private WebElement facebookIcon;
    @FindBy(className = "social_linkedin")
    private WebElement linkedinIcon;
    @FindBy(className = "inventory_item_name")
    List<WebElement> productNames;
    @FindBy(css = ".btn_inventory")
    List<WebElement> productButtons;







    public InventoryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

        }
    public String getPageTitle() {
        return logo.getText();
    }

    public boolean isCartIconDisplayed()
    {
        return cartIcon.isDisplayed();
    }

    public int getProductsCount() {
        return inventoryItem.size();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public void openCart() {
        cartIcon.click();
    }


    public void clickLinkedin() {
        linkedinIcon.click();
    }

    public void clickFacebook() {
        facebookIcon.click();
    }

    public void clickTwitter() {
        twitterIcon.click();
    }

    public void addProductToCart(String productName) {
        for (int i = 0; i < productNames.size(); i++) {
            if (productNames.get(i).getText().equals(productName)) {
                productButtons.get(i).click();
                break;
            }
        }
    }

    public String getProductButtonText(String productName) {
        for (int i = 0; i < productNames.size(); i++) {
            if (productNames.get(i).getText().equals(productName)) {
                return productButtons.get(i).getText();
            }
        }
        return "Product not found";
    }

}

