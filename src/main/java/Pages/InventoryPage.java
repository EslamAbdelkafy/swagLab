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
}

