package stepdefinitions;

import io.cucumber.java.en.*;
import pages.HomePage;
import pages.LoginPage;
import utils.DriverManager;
import org.testng.Assert;

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
        Assert.assertTrue(DriverManager.getDriver().getCurrentUrl().contains("/secure"), "Login was not successful");
    }

    @Given("user is logged in")
    public void userIsLoggedIn() {
        openLogin();
        login.login("tomsmith","SuperSecretPassword!");
        Assert.assertTrue(DriverManager.getDriver().getCurrentUrl().contains("/secure"));
    }

    @When("user lands on home page")
    public void userLandsOnHomePage() {
        homePage.userLandsOnHomePage();
    }

    @Then("product list should be visible")
    public void productListShouldBeVisible() {
        homePage.productListShouldBeVisible();
    }

    @Given("user is on home page")
    public void userIsOnHomePage() {
        if (!DriverManager.getDriver().getCurrentUrl().contains("/secure")) {
            userIsLoggedIn();
        }
    }

    @When("user searches for {string}")
    public void userSearchesFor(String query) {
        homePage.searchFor(query);
    }

    @Then("relevant search results should be displayed")
    public void relevantSearchResultsShouldBeDisplayed() {
        homePage.relevantSearchResultsShouldBeDisplayed();
    }

    @When("user adds first product to cart")
    public void userAddsFirstProductToCart() {
        homePage.addFirstProductToCart();
    }

    @Then("product should be added successfully")
    public void productShouldBeAddedSuccessfully() {
        homePage.productShouldBeAddedSuccessfully();
    }
}
