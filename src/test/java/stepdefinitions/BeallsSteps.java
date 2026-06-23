package stepdefinitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import pages.BeallsCheckoutPage;
import pages.BeallsHomePage;
import pages.BeallsMyBagPage;
import pages.BeallsSearchResultsPage;
import utils.DriverManager;

public class BeallsSteps {

    BeallsHomePage beallsHomePage = new BeallsHomePage(DriverManager.getDriver());
    BeallsSearchResultsPage beallsSearchResultsPage = new BeallsSearchResultsPage(DriverManager.getDriver());
    BeallsMyBagPage beallsMyBagPage = new BeallsMyBagPage(DriverManager.getDriver());
    BeallsCheckoutPage beallsCheckoutPage = new BeallsCheckoutPage(DriverManager.getDriver());

    @Given("the user is on the Bealls home page {string}")
    public void the_user_is_on_the_bealls_home_page(String url) {
        beallsHomePage.navigateTo(url);
    }

    @Given("the user has not signed in")
    public void the_user_has_not_signed_in() {
        System.out.println("User is a guest.");
    }

    @When("the user enters {string} into the search field")
    public void the_user_enters_into_the_search_field(String keyword) {
        beallsHomePage.enterSearchKeyword(keyword);
    }

    @When("the user press the {string} button to search product")
    public void the_user_press_the_button_to_search_product(String button) {
        if (button.equalsIgnoreCase("Enter")) {
            beallsHomePage.pressEnterToSearch();
        }
    }

    @Then("User will wait for search results page and page heading should contain {string}")
    public void user_will_wait_for_search_results_page_and_page_heading_should_contain(String heading) {
        beallsSearchResultsPage.waitForSearchResultsPage();
        Assert.assertTrue(beallsSearchResultsPage.getPageHeadingText().contains(heading));
    }

    @Then("the result count is greater than {int}")
    public void the_result_count_is_greater_than(Integer count) {
        Assert.assertTrue(beallsSearchResultsPage.getResultCount() > count);
    }

    @Then("Wait for Add to bag button in list")
    public void wait_for_add_to_bag_button_in_list() {
        beallsSearchResultsPage.waitForAddToBagButton();
    }

    @Then("Scroll till Add to bag button in list and click on it")
    public void scroll_till_add_to_bag_button_in_list_and_click_on_it() {
        beallsSearchResultsPage.scrollAndClickAddToBag();
    }

    @Then("A pop-up is visible with message that the product is added")
    public void a_pop_up_is_visible_with_message_that_the_product_is_added() {
        Assert.assertTrue(beallsSearchResultsPage.isAddedPopupVisible());
    }

    @Then("Wait pop-up is hide with message that the product is added")
    public void wait_pop_up_is_hide_with_message_that_the_product_is_added() {
        beallsSearchResultsPage.waitForAddedPopupToDisappear();
    }

    @Then("Scroll till bag icon and click on bag icon")
    public void scroll_till_bag_icon_and_click_on_bag_icon() {
        beallsMyBagPage.scrollAndClickBagIcon();
    }

    @Then("Wait to be visible My Bag page and page heading contains text {string}")
    public void wait_to_be_visible_my_bag_page_and_page_heading_contains_text(String heading) {
        beallsMyBagPage.waitForMyBagPage();
        Assert.assertTrue(beallsMyBagPage.getPageHeadingText().contains(heading));
    }

    @Then("The bag product count is greater than {int}")
    public void the_bag_product_count_is_greater_than(Integer count) {
        Assert.assertTrue(beallsMyBagPage.getBagProductCount() > count);
    }

    @Then("Wait for Checkout as guest button is clickable")
    public void wait_for_checkout_as_guest_button_is_clickable() {
        beallsMyBagPage.waitForCheckoutAsGuestButton();
    }

    @Then("Scroll to Checkout as guest button and click on it")
    public void scroll_to_checkout_as_guest_button_and_click_on_it() {
        beallsMyBagPage.scrollAndClickCheckoutAsGuest();
    }

    @Then("Wait to be visible checkout page and page heading contains text {string}")
    public void wait_to_be_visible_checkout_page_and_page_heading_contains_text(String heading) {
        beallsCheckoutPage.waitForCheckoutPage();
        Assert.assertTrue(beallsCheckoutPage.getPageHeadingText().contains(heading));
    }
}
