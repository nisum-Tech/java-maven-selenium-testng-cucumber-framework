package stepdefinitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import pages.GoogleHomePage;
import pages.GoogleSearchResultsPage;
import pages.ProductPage;
import utils.DriverManager;

public class GoogleSearchSteps {

    GoogleHomePage googleHomePage = new GoogleHomePage(DriverManager.getDriver());
    GoogleSearchResultsPage googleSearchResultsPage = new GoogleSearchResultsPage(DriverManager.getDriver());
    ProductPage productPage = new ProductPage(DriverManager.getDriver());

    @Given("I am on the Google search page {string}")
    public void i_am_on_the_google_search_page(String url) {
        googleHomePage.navigateTo(url);
    }

    @When("I search for {string}")
    public void i_search_for(String searchText) {
        googleHomePage.searchFor(searchText);
    }

    @When("I click on the search result with text {string}")
    public void i_click_on_the_search_result_with_text(String linkText) {
        googleSearchResultsPage.clickSearchResultByText(linkText);
    }

    @When("I click on a product link")
    public void i_click_on_a_product_link() {
        googleSearchResultsPage.clickProductLink();
    }

    @When("I select a product option {string}")
    public void i_select_a_product_option(String optionValue) {
        productPage.selectProductOption(optionValue);
    }

    @When("I add the product to the cart")
    public void i_add_the_product_to_the_cart() {
        productPage.addToCart();
    }

    @Then("I should see a confirmation that the product was added to the cart")
    public void i_should_see_a_confirmation_that_the_product_was_added_to_the_cart() {
        Assert.assertTrue("Confirmation message was not displayed.", productPage.isProductAddedToCart());
    }
}
