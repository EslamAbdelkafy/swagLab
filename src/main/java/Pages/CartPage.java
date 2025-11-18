package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage {
    private WebDriver driver;
    @FindBy(className = "cart_item")
    List<WebElement> cartItems;

    @FindBy(id = "continue-shopping")
    WebElement continueShoppingBtn;

    @FindBy(className = "inventory_item_name")
    List<WebElement> productNames;


    @FindBy(css = "button[class*='btn_secondary']")
    List<WebElement> removeButtons;



    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public int getCartItemsCount() {
        return cartItems.size();
    }

    public boolean isCartEmpty() {
        return cartItems.isEmpty();
    }

    public void clickContinueShopping() {
        continueShoppingBtn.click();
    }
    public boolean isProductInCart(String productName) {
        for (WebElement name : productNames) {
            if (name.getText().equals(productName)) {
                return true;
            }
        }
        return false;
    }


    public void removeProduct(String productName) {
        for (int i = 0; i < productNames.size(); i++) {
            if (productNames.get(i).getText().equals(productName)) {
                removeButtons.get(i).click();
                break;
            }
        }
    }



}
