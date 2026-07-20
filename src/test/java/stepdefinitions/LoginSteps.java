package stepdefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.testng.Assert;
import pages.HomePage;
import pages.LoginPage;
import utils.DriverManager;

public class LoginSteps {

    LoginPage login = new LoginPage(DriverManager.getDriver());
    HomePage homePage = new HomePage(DriverManager.getDriver());

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

    @Given("user is logged in")
    public void user_is_logged_in() {
        // NOTE: This test operates on saucedemo.com, which is different from other tests in this file.
        // The existing LoginPage is not compatible. A direct login implementation is used here.
        DriverManager.getDriver().get("https://www.saucedemo.com/");
        DriverManager.getDriver().findElement(By.id("user-name")).sendKeys("standard_user");
        DriverManager.getDriver().findElement(By.id("password")).sendKeys("secret_sauce");
        DriverManager.getDriver().findElement(By.id("login-button")).click();
        Assert.assertTrue(homePage.isOnHomePage(), "Login was not successful or did not land on home page.");
    }

    @When("user lands on home page")
    public void user_lands_on_home_page() {
        Assert.assertTrue(homePage.isOnHomePage(), "User is not on the home page.");
    }

    @Then("product list should be visible")
    public void product_list_should_be_visible() {
        homePage.verifyProductListIsVisible();
    }

    @Given("user is on home page")
    public void user_is_on_home_page() {
        // This step assumes the user is already on the home page.
        // If not, it performs a login as a prerequisite.
        if (!homePage.isOnHomePage()) {
            user_is_logged_in();
        }
        Assert.assertTrue(homePage.isOnHomePage(), "Precondition failed: User is not on home page.");
    }

    @When("user searches for {string}")
    public void user_searches_for(String product) {
        homePage.searchForProduct(product);
    }

    @Then("relevant search results should be displayed")
    public void relevant_search_results_should_be_displayed() {
        homePage.verifySearchResultsDisplayed();
    }

    @When("user adds first product to cart")
    public void user_adds_first_product_to_cart() {
        homePage.addFirstProductToCart();
    }

    @Then("product should be added successfully")
    public void product_should_be_added_successfully() {
        homePage.verifyProductAddedToCart();
    }
}
