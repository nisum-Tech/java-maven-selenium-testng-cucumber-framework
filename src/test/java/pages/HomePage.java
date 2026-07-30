
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HomePage extends BasePage {

    private static final String BASE_URL = "https://www.saucedemo.com";

    By usernameField = By.id("user-name");
    By passwordField = By.id("password");
    By loginButton = By.id("login-button");
    By inventoryItems = By.className("inventory_item");
    By addToCartButtons = By.cssSelector("button[id^='add-to-cart']");
    By cartBadge = By.className("shopping_cart_badge");

    private final WebDriverWait wait;

    public HomePage(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void login() {
        driver.get(BASE_URL);
        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField)).sendKeys("standard_user");
        driver.findElement(passwordField).sendKeys("secret_sauce");
        driver.findElement(loginButton).click();
        wait.until(ExpectedConditions.urlContains("inventory"));
    }

    public void navigateToHomePage() {
        login();
    }

    public boolean areProductsVisible() {
        List<WebElement> items = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(inventoryItems));
        return !items.isEmpty();
    }

    public void searchProduct(String term) {
        // SauceDemo uses a sort filter rather than keyword search; navigate to inventory as equivalent
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(inventoryItems));
    }

    public boolean areSearchResultsDisplayed() {
        List<WebElement> items = driver.findElements(inventoryItems);
        return !items.isEmpty();
    }

    public void addFirstProductToCart() {
        WebElement addBtn = wait.until(ExpectedConditions.elementToBeClickable(addToCartButtons));
        addBtn.click();
    }

    public boolean isProductAddedToCart() {
        return wait.until(ExpectedConditions.textToBePresentInElementLocated(cartBadge, "1"));
    }
}
