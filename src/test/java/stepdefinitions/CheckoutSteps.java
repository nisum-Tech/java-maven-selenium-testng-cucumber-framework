
package stepdefinitions;

import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.CheckoutPage;
import utils.DriverManager;

public class CheckoutSteps {

    CheckoutPage checkoutPage = new CheckoutPage(DriverManager.getDriver());

    @Given("user has items in cart")
    public void userHasItemsInCart() {
        checkoutPage.addItemToCartAndGoToCart();
    }

    @When("user proceeds to checkout")
    public void userProceedsToCheckout() {
        checkoutPage.proceedToCheckout();
    }

    @When("enters valid shipping details")
    public void entersValidShippingDetails() {
        checkoutPage.enterValidShippingDetails();
    }

    @When("confirms payment")
    public void confirmsPayment() {
        checkoutPage.confirmPayment();
    }

    @Then("order should be placed successfully")
    public void orderShouldBePlacedSuccessfully() {
        Assert.assertTrue(checkoutPage.isOrderPlaced(), "Order confirmation not found");
    }

    @When("leaves shipping details empty")
    public void leavesShippingDetailsEmpty() {
        checkoutPage.leaveShippingDetailsEmpty();
    }

    @Then("validation errors should be shown")
    public void validationErrorsShouldBeShown() {
        Assert.assertTrue(checkoutPage.areValidationErrorsShown(), "Validation errors were not displayed");
    }

    @When("user opens checkout page")
    public void userOpensCheckoutPage() {
        checkoutPage.openCheckoutPage();
    }

    @When("clicks cancel button")
    public void clicksCancelButton() {
        checkoutPage.clickCancel();
    }

    @Then("user should be redirected to cart page")
    public void userShouldBeRedirectedToCartPage() {
        Assert.assertTrue(checkoutPage.isOnCartPage(), "User was not redirected to cart page after cancel");
    }
}
