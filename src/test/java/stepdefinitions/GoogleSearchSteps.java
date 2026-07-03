package stepdefinitions;

import io.cucumber.java.en.*;
import pages.GoogleSearchPage;
import pages.NisumHomePage;
import pages.NisumDigitalStrategyPage;
import utils.DriverManager;

public class GoogleSearchSteps {

    private GoogleSearchPage googleSearchPage = new GoogleSearchPage(DriverManager.getDriver());
    private NisumHomePage nisumHomePage = new NisumHomePage(DriverManager.getDriver());
    private NisumDigitalStrategyPage nisumDigitalStrategyPage = new NisumDigitalStrategyPage(DriverManager.getDriver());

    @Given("user is on the Google search page")
    public void user_is_on_the_google_search_page() {
        googleSearchPage.navigateToGoogle();
    }

    @When("user searches for {string}")
    public void user_searches_for(String searchTerm) {
        googleSearchPage.searchFor(searchTerm);
    }

    @And("clicks the Nisum search result link")
    public void clicks_the_nisum_search_result_link() {
        googleSearchPage.clickNisumLink();
    }

    @And("clicks the Digital Strategy link on the home page")
    public void clicks_the_digital_strategy_link_on_the_home_page() {
        nisumHomePage.clickDigitalStrategyLink();
    }

    @Then("the Digital Strategy page is displayed")
    public void the_digital_strategy_page_is_displayed() {
        nisumDigitalStrategyPage.verifyPageHeadingIsVisible();
    }
}
