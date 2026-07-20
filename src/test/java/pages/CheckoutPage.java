package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CheckoutPage extends BasePage {

    // NOTE: Locators not provided, using placeholders.
    private final By checkoutButton = By.id("checkout");
    private final By firstNameInput = By.id("first-name");
    private final By lastNameInput = By.id("last-name");
    private final By postalCodeInput = By.id("postal-code");
    private final By continueButton = By.id("continue");
    private final By finishButton = By.id("finish");
    private final By orderConfirmationMessage = By.className("complete-header");
    private final By errorMessageContainer = By.cssSelector("h3[data-test='error']");
    private final By cancelButton = By.id("cancel");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public void proceedToCheckout() {
        driver.findElement(checkoutButton).click();
    }

    public void enterShippingDetails(String firstName, String lastName, String postalCode) {
        driver.findElement(firstNameInput).sendKeys(firstName);
        driver.findElement(lastNameInput).sendKeys(lastName);
        driver.findElement(postalCodeInput).sendKeys(postalCode);
        driver.findElement(continueButton).click();
    }

    public void confirmPayment() {
        driver.findElement(finishButton).click();
    }

    public void verifyOrderPlacedSuccessfully() {
        Assert.assertTrue(driver.findElement(orderConfirmationMessage).isDisplayed(), "Order was not placed successfully.");
    }

    public void proceedWithEmptyShippingDetails() {
        driver.findElement(continueButton).click();
    }

    public void verifyValidationErrorsShown() {
        Assert.assertTrue(driver.findElement(errorMessageContainer).isDisplayed(), "Validation errors are not shown.");
    }

    public void openCheckoutPage() {
        // Assuming this is clicked from the cart page.
        driver.findElement(checkoutButton).click();
    }

    public void clickCancel() {
        driver.findElement(cancelButton).click();
    }
}
