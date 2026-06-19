
package stepdefinitions;

import io.cucumber.java.en.*;
import pages.LoginPage;
import utils.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginSteps {

    LoginPage login = new LoginPage(DriverManager.getDriver());

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
    public void user_has_items_in_cart() {
        // This step is for a checkout feature, which is not available on the-internet.herokuapp.com.
        // The implementation will use https://www.saucedemo.com/ as the target application.
        // This requires a separate login and application context from the existing steps in this file.
        WebDriver driver = DriverManager.getDriver();
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        // Add item to cart
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();

        // Go to cart
        driver.findElement(By.className("shopping_cart_link")).click();
    }

    @When("user proceeds to checkout")
    public void user_proceeds_to_checkout() {
        DriverManager.getDriver().findElement(By.id("checkout")).click();
    }

    @And("enters valid shipping details")
    public void enters_valid_shipping_details() {
        DriverManager.getDriver().findElement(By.id("first-name")).sendKeys("Test");
        DriverManager.getDriver().findElement(By.id("last-name")).sendKeys("User");
        DriverManager.getDriver().findElement(By.id("postal-code")).sendKeys("12345");
        DriverManager.getDriver().findElement(By.id("continue")).click();
    }

    @And("confirms payment")
    public void confirms_payment() {
        DriverManager.getDriver().findElement(By.id("finish")).click();
    }

    @Then("order should be placed successfully")
    public void order_should_be_placed_successfully() {
        String confirmationText = DriverManager.getDriver().findElement(By.className("complete-header")).getText();
        Assert.assertEquals(confirmationText, "THANK YOU FOR YOUR ORDER", "Order was not placed successfully.");
    }

    @And("leaves shipping details empty")
    public void leaves_shipping_details_empty() {
        // This is for a negative scenario. We just proceed without entering data.
        DriverManager.getDriver().findElement(By.id("continue")).click();
    }

    @Then("validation errors should be shown")
    public void validation_errors_should_be_shown() {
        boolean error = DriverManager.getDriver().findElement(By.cssSelector("h3[data-test='error']")).isDisplayed();
        Assert.assertTrue(error, "Validation errors were not shown.");
        String errorMessage = DriverManager.getDriver().findElement(By.cssSelector("h3[data-test='error']")).getText();
        Assert.assertTrue(errorMessage.contains("First Name is required"));
    }

    @When("user opens checkout page")
    public void user_opens_checkout_page() {
        // This scenario seems to start from the checkout page directly.
        // A prerequisite would be having items in the cart and being logged in.
        // To make this step runnable independently for its scenario, we'll perform the prerequisite actions here.
        user_has_items_in_cart(); // Sets up cart
        user_proceeds_to_checkout(); // Navigates to checkout
    }

    @And("clicks cancel button")
    public void clicks_cancel_button() {
        // On checkout-step-one.html or checkout-step-two.html there's a cancel button.
        DriverManager.getDriver().findElement(By.id("cancel")).click();
    }

    @Then("user should be redirected to cart page")
    public void user_should_be_redirected_to_cart_page() {
        String currentUrl = DriverManager.getDriver().getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://www.saucedemo.com/cart.html", "User was not redirected to the cart page.");
    }
}
