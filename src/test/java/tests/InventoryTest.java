package tests;

import Pages.InventoryPage;
import Pages.LoginPage;
import base.BaseTests;
import com.google.gson.JsonObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.DataDriven;

public class InventoryTest extends BaseTests {
    private InventoryPage inventoryPage;
    private final String dataPath = "src/test/resources/testData.json";

    private void loginWithValidCreds() {
        JsonObject data = DataDriven.jsonReader(dataPath);
        JsonObject valid = data.getAsJsonObject("valid");
        String username = valid.get("username").getAsString();
        String password = valid.get("password").getAsString();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username, password);
    }



    @Test

    public void verifyInventoryPageElements() {
        InventoryPage inventoryPage = new InventoryPage(driver);
        loginWithValidCreds();

        Assert.assertEquals(inventoryPage.getPageTitle(), "Swag Labs",
                "The page title is incorrect.");


        Assert.assertTrue(inventoryPage.isCartIconDisplayed(),
                "The basket icon is not visible");


        Assert.assertEquals(inventoryPage.getProductsCount(), 6,
                "The number of products is incorrect.");
    }
}
