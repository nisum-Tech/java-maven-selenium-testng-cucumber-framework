package stepdefinitions;

import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.OlxHomePage;
import pages.OlxMobilesCategoryPage;
import utils.DriverManager;

public class OlxSteps {

    private OlxHomePage olxHomePage;
    private OlxMobilesCategoryPage olxMobilesCategoryPage;

    @Given("I am on the OLX home page")
    public void i_am_on_the_olx_home_page() {
        olxHomePage = new OlxHomePage(DriverManager.getDriver());
        olxHomePage.navigateToHomePage();
    }

    @When("I click on the Mobiles category")
    public void i_click_on_the_mobiles_category() {
        olxHomePage.clickMobilesCategory();
    }

    @When("I click on the Mobile Phones sub-category")
    public void i_click_on_the_mobile_phones_sub_category() {
        olxMobilesCategoryPage = new OlxMobilesCategoryPage(DriverManager.getDriver());
        olxMobilesCategoryPage.clickMobilePhonesSubCategory();
    }

    @When("I filter by location {string}")
    public void i_filter_by_location(String location) {
        olxMobilesCategoryPage.selectKarachi(); //This is hardcoded due to locator in plan
    }

    @When("I filter by sub-location {string}")
    public void i_filter_by_sub_location(String subLocation) {
        olxMobilesCategoryPage.selectGulshanEIqbal(); //This is hardcoded due to locator in plan
    }

    @Then("I should see search results for mobile phones in Gulshan-e-Iqbal Town")
    public void i_should_see_search_results_for_mobile_phones_in_gulshan_e_iqbal_town() {
        Assert.assertTrue(olxMobilesCategoryPage.isResultsPageVisible(), "Results page is not visible or header is incorrect.");
    }
}
