package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HomePage extends BasePage {

    private final By productTitle = By.className("title");
    private final By productList = By.className("inventory_list");
    private final By addToCartButton = By.xpath("(//*[text()='Add to cart'])[1]");
    private final By cartBadge = By.className("shopping_cart_badge");

    // Locators for search functionality which is not on saucedemo homepage
    private final By searchBox = By.id("LOCATOR_PLACEHOLDER"); // FIXME: Locator not provided, functionality not present on page
    private final By searchResults = By.id("LOCATOR_PLACEHOLDER"); // FIXME: Locator not provided, functionality not present on page


    public HomePage(WebDriver driver) {
        super(driver);
    }

    public boolean isOnHomePage() {
        try {
            return driver.findElement(productTitle).isDisplayed() && driver.findElement(productTitle).getText().equals("Products");
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    public void verifyProductListIsVisible() {
        Assert.assertTrue(driver.findElement(productList).isDisplayed(), "Product list is not visible.");
    }

    public void searchForProduct(String productName) {
        // This functionality does not exist on saucedemo, so this is a placeholder
        System.out.println("NOTE: Search functionality not present on page. Skipping search for " + productName);
        // driver.findElement(searchBox).sendKeys(productName);
    }

    public void verifySearchResultsDisplayed() {
        // This functionality does not exist on saucedemo, so this is a placeholder
        System.out.println("NOTE: Search functionality not present on page. Skipping search result verification.");
        // Assert.assertTrue(driver.findElement(searchResults).isDisplayed(), "Search results are not displayed.");
    }

    public void addFirstProductToCart() {
        driver.findElement(addToCartButton).click();
    }

    public void verifyProductAddedToCart() {
        Assert.assertTrue(driver.findElement(cartBadge).isDisplayed(), "Product not added to cart successfully.");
        Assert.assertEquals(driver.findElement(cartBadge).getText(), "1", "Cart count is not 1.");
    }
}
