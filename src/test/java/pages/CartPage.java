package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CartPage extends BasePage {

    // NOTE: Locator not provided, using a placeholder.
    private final By cartTitle = By.xpath("//span[contains(text(),'Your Cart')]");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void verifyIsOnCartPage() {
        Assert.assertTrue(driver.findElement(cartTitle).isDisplayed(), "Not on the cart page.");
    }
}
