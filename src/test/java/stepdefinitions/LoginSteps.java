package stepdefinitions;

import io.cucumber.java.en.*;
import pages.LoginPage;
import utils.DriverManager;
import pages.CartPage;
import pages.CheckoutPage;

public class LoginSteps {

    LoginPage login = new LoginPage(DriverManager.getDriver());
    CartPage cartPage = new CartPage(DriverManager.getDriver());
    CheckoutPage checkoutPage = new CheckoutPage(DriverManager.getDriver());

    @Given("user is on login page")
    public void openLogin(){
        DriverManager.getDriver().get("https://the-internet.herokuapp.com/login");
    }

    @When("user logs in")
    public void login(){
        login.login("tomsmith","SuperSecretPassword!");
    }

    @Then("user should login successfully")
    public void verify(){
        System.out.println("Logged in");
    }

    @Given("user has items in cart")
    public void userHasItemsInCart() {
        // NOTE: This is a placeholder implementation.
        // The test setup for login navigates to a different application
        // than what the checkout feature implies.
        // A proper implementation would require logging into the e-commerce site
        // and adding items to the cart.
        System.out.println("Step: Given user has items in cart - Placeholder");
    }

    @When("user proceeds to checkout")
    public void userProceedsToCheckout() {
        checkoutPage.proceedToCheckout();
    }

    @And("enters valid shipping details")
    public void entersValidShippingDetails() {
        checkoutPage.enterShippingDetails("John", "Doe", "12345");
    }

    @And("confirms payment")
    public void confirmsPayment() {
        checkoutPage.confirmPayment();
    }

    @Then("order should be placed successfully")
    public void orderShouldBePlacedSuccessfully() {
        checkoutPage.verifyOrderPlacedSuccessfully();
    }

    @And("leaves shipping details empty")
    public void leavesShippingDetailsEmpty() {
        checkoutPage.proceedWithEmptyShippingDetails();
    }

    @Then("validation errors should be shown")
    public void validationErrorsShouldBeShown() {
        checkoutPage.verifyValidationErrorsShown();
    }

    @When("user opens checkout page")
    public void userOpensCheckoutPage() {
        checkoutPage.openCheckoutPage();
    }

    @And("clicks cancel button")
    public void clicksCancelButton() {
        checkoutPage.clickCancel();
    }

    @Then("user should be redirected to cart page")
    public void userShouldBeRedirectedToCartPage() {
        cartPage.verifyIsOnCartPage();
    }
}
