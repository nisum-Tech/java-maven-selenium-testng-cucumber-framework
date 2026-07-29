
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutPage extends BasePage {

    private static final String BASE_URL = "https://www.saucedemo.com";

    By checkoutButton = By.id("checkout");
    By firstNameField = By.id("first-name");
    By lastNameField = By.id("last-name");
    By zipField = By.id("postal-code");
    By continueButton = By.id("continue");
    By finishButton = By.id("finish");
    By cancelButton = By.id("cancel");
    By errorMessage = By.cssSelector("[data-test='error']");
    By successHeader = By.className("complete-header");

    private final WebDriverWait wait;

    public CheckoutPage(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void addItemToCartAndGoToCart() {
        driver.get(BASE_URL);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user-name"))).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        wait.until(ExpectedConditions.urlContains("inventory"));
        wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("button[id^='add-to-cart']"))).click();
        driver.get(BASE_URL + "/cart.html");
    }

    public void proceedToCheckout() {
        wait.until(ExpectedConditions.elementToBeClickable(checkoutButton)).click();
    }

    public void openCheckoutPage() {
        wait.until(ExpectedConditions.elementToBeClickable(checkoutButton)).click();
    }

    public void enterValidShippingDetails() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameField)).sendKeys("John");
        driver.findElement(lastNameField).sendKeys("Doe");
        driver.findElement(zipField).sendKeys("12345");
        driver.findElement(continueButton).click();
    }

    public void confirmPayment() {
        wait.until(ExpectedConditions.elementToBeClickable(finishButton)).click();
    }

    public boolean isOrderPlaced() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(successHeader))
                   .getText()
                   .contains("Thank you");
    }

    public void leaveShippingDetailsEmpty() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameField));
        driver.findElement(continueButton).click();
    }

    public boolean areValidationErrorsShown() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage)).isDisplayed();
    }

    public void clickCancel() {
        wait.until(ExpectedConditions.elementToBeClickable(cancelButton)).click();
    }

    public boolean isOnCartPage() {
        return driver.getCurrentUrl().contains("cart.html");
    }
}
