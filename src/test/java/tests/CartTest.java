package tests;

import Pages.CartPage;
import Pages.InventoryPage;
import Pages.LoginPage;
import base.BaseTests;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.DataDriven;

import java.time.Duration;
import java.util.ArrayList;


public class CartTest extends BaseTests {
    LoginPage loginPage;
    InventoryPage inventoryPage;
    CartPage cartPage;


    @BeforeMethod
    public void setupPages() {
        loginPage = new LoginPage(driver);
        inventoryPage = new InventoryPage(driver);
        cartPage = new CartPage(driver);
        loginPage.login("standard_user", "secret_sauce");
    }

    @Test(priority = 1)
    public void verifylinkedin() {
        InventoryPage inv = new InventoryPage(driver);
        inv.clickLinkedin();
        driver.switchTo().window(new ArrayList<>(driver.getWindowHandles()).get(1));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("linkedin"));
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("linkedin"));
        driver.close();

    }

    @Test(priority = 2)
    public void verifyFacebook() {
        InventoryPage inv = new InventoryPage(driver);
        inv.clickFacebook();
        driver.switchTo().window(new ArrayList<>(driver.getWindowHandles()).get(1));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("facebook"));
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("facebook"));
        driver.close();
    }

    @Test(priority = 3)
    public void verifyTwitter() {
        InventoryPage inv = new InventoryPage(driver);
        inv.clickTwitter();
        driver.switchTo().window(new ArrayList<>(driver.getWindowHandles()).get(1));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("x.com"));
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("x.com"));
        driver.navigate().back();
        driver.close();
    }

    @Test(priority = 4)
    public void verifyCartIsEmpty() {
        inventoryPage.openCart(); CartPage cart = new CartPage(driver);
        Assert.assertEquals(cart.getCartItemsCount(), 0,
                "Cart should be empty!");
    }

    @Test(priority = 5)
    public void addThreeSpecificProducts() {
        inventoryPage.addProductToCart("Sauce Labs Backpack");
        inventoryPage.addProductToCart("Sauce Labs Bolt T-Shirt");
        inventoryPage.addProductToCart("Sauce Labs Fleece Jacket");
        inventoryPage.openCart();

        Assert.assertEquals(cartPage.getCartItemsCount(), 3);

        Assert.assertTrue(cartPage.isProductInCart("Sauce Labs Backpack"));
        Assert.assertTrue(cartPage.isProductInCart("Sauce Labs Bolt T-Shirt"));
        Assert.assertTrue(cartPage.isProductInCart("Sauce Labs Fleece Jacket"));
    }

    @Test(priority = 6)
    public void removeOneProduct() {
        inventoryPage.addProductToCart("Sauce Labs Backpack");
        inventoryPage.addProductToCart("Sauce Labs Bolt T-Shirt");
        inventoryPage.addProductToCart("Sauce Labs Fleece Jacket");
        inventoryPage.openCart();

        cartPage.removeProduct("Sauce Labs Bolt T-Shirt");

        Assert.assertEquals(cartPage.getCartItemsCount(), 2);

        Assert.assertTrue(cartPage.isProductInCart("Sauce Labs Backpack"));
        Assert.assertTrue(cartPage.isProductInCart("Sauce Labs Fleece Jacket"));
        Assert.assertFalse(cartPage.isProductInCart("Sauce Labs Bolt T-Shirt"));
    }

}




