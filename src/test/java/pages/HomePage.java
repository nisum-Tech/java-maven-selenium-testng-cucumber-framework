package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HomePage extends BasePage {

    // FIXME: Locators are placeholders.
    By productList = By.id("TODO_locator_not_provided_for_product_list");
    By searchBox = By.id("TODO_locator_not_provided_for_search_box");
    By searchButton = By.id("TODO_locator_not_provided_for_search_button");
    By addToCartButton = By.id("TODO_locator_not_provided_for_add_to_cart");
    By successMessage = By.id("TODO_locator_not_provided_for_success_message");
    By searchResults = By.id("TODO_locator_not_provided_for_search_results");


    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void productListShouldBeVisible() {
        Assert.assertTrue(driver.findElement(productList).isDisplayed());
    }

    public void searchFor(String query) {
        driver.findElement(searchBox).sendKeys(query);
        driver.findElement(searchButton).click();
    }

    public void relevantSearchResultsShouldBeDisplayed() {
        Assert.assertTrue(driver.findElement(searchResults).isDisplayed());
    }

    public void addFirstProductToCart() {
        driver.findElement(addToCartButton).click();
    }

    public void productShouldBeAddedSuccessfully() {
        Assert.assertTrue(driver.findElement(successMessage).isDisplayed());
    }

    public void userLandsOnHomePage() {
        // After login, user is typically redirected to the home page.
        // This can also be an explicit navigation if needed.
        Assert.assertTrue(driver.getCurrentUrl().contains("secure"));
    }
}
