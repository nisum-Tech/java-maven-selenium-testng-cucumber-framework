package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.OlxHomePage;
import pages.OlxSearchResultsPage;
import utils.DriverManager;

public class RecordedFlowSteps {

    OlxHomePage olxHomePage = new OlxHomePage(DriverManager.getDriver());
    OlxSearchResultsPage olxSearchResultsPage = new OlxSearchResultsPage(DriverManager.getDriver());

    @Given("user is on the OLX home page")
    public void user_is_on_the_olx_home_page() {
        olxHomePage.navigateToHomePage();
    }

    @When("user clicks on Vehicles category")
    public void user_clicks_on_vehicles_category() {
        olxHomePage.clickVehiclesCategory();
    }

    @And("user hovers over vehicles in Pakistan")
    public void user_hovers_over_vehicles_in_pakistan() {
        olxSearchResultsPage.hoverVehiclesInPakistan();
    }

    @And("user clicks on a vehicle sub-category")
    public void user_clicks_on_a_vehicle_sub_category() {
        olxSearchResultsPage.clickVehicleSubCategory();
    }

    @And("user hovers over a generic element")
    public void user_hovers_over_a_generic_element() {
        olxSearchResultsPage.hoverGenericElement();
    }

    @And("user clicks on Gulshan-e-Iqbal Town")
    public void user_clicks_on_gulshan_e_iqbal_town() {
        olxSearchResultsPage.clickGulshanEIqbalTown();
    }

    @Then("user clicks on a search result")
    public void user_clicks_on_a_search_result() {
        olxSearchResultsPage.clickSearchResult();
    }
}
