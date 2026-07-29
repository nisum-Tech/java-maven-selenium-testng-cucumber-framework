
package stepdefinitions;

import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.HomePage;
import utils.DriverManager;

public class HomeSteps {

    HomePage homePage = new HomePage(DriverManager.getDriver());

    @Given("user is logged in")
    public void userIsLoggedIn() {
        homePage.login();
    }

    @When("user lands on home page")
    public void userLandsOnHomePage() {
        // already on inventory page after login
    }

    @Then("product list should be visible")
    public void productListShouldBeVisible() {
        Assert.assertTrue(homePage.areProductsVisible(), "Product list is not visible on home page");
    }

    @Given("user is on home page")
    public void userIsOnHomePage() {
        homePage.navigateToHomePage();
    }

    @When("user searches for {string}")
    public void userSearchesFor(String term) {
        homePage.searchProduct(term);
    }

    @Then("relevant search results should be displayed")
    public void relevantSearchResultsShouldBeDisplayed() {
        Assert.assertTrue(homePage.areSearchResultsDisplayed(), "No search results found");
    }

    @When("user adds first product to cart")
    public void userAddsFirstProductToCart() {
        homePage.addFirstProductToCart();
    }

    @Then("product should be added successfully")
    public void productShouldBeAddedSuccessfully() {
        Assert.assertTrue(homePage.isProductAddedToCart(), "Cart badge did not show 1 after adding product");
    }
}
