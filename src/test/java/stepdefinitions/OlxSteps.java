package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.OlxHomePage;
import pages.OlxPostAdPage;
import utils.DriverManager;

public class OlxSteps {

    private OlxHomePage olxHomePage = new OlxHomePage(DriverManager.getDriver());
    private OlxPostAdPage olxPostAdPage = new OlxPostAdPage(DriverManager.getDriver());

    @Given("user navigates to {string}")
    public void user_navigates_to(String url) {
        olxHomePage.navigateTo(url);
    }

    @Given("user is logged into OLX account")
    public void user_is_logged_into_olx_account() {
        olxHomePage.login();
    }

    @When("user clicks on {string}")
    public void user_clicks_on(String buttonName) {
        if ("Post an Ad".equalsIgnoreCase(buttonName)) {
            olxHomePage.clickPostAd();
        } else {
            throw new IllegalArgumentException("Button '" + buttonName + "' is not supported in this step definition.");
        }
    }

    @When("user selects category {string}")
    public void user_selects_category(String category) {
        olxPostAdPage.selectCategory(category);
    }

    @When("user enters title {string}")
    public void user_enters_title(String title) {
        olxPostAdPage.enterTitle(title);
    }

    @When("user enters description {string}")
    public void user_enters_description(String description) {
        olxPostAdPage.enterDescription(description);
    }

    @When("user enters price {string}")
    public void user_enters_price(String price) {
        olxPostAdPage.enterPrice(price);
    }

    @When("user uploads product images")
    public void user_uploads_product_images() {
        olxPostAdPage.uploadImages();
    }

    @When("user submits the ad")
    public void user_submits_the_ad() {
        olxPostAdPage.submitAd();
    }

    @Then("ad should be posted successfully")
    public void ad_should_be_posted_successfully() {
        olxPostAdPage.verifyAdPostedSuccessfully();
    }

    @Then("user should see confirmation message")
    public void user_should_see_confirmation_message() {
        olxPostAdPage.verifyConfirmationMessage();
    }
}
