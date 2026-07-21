package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.GoogleSearchPage;
import pages.PakWheelsHomePage;
import pages.PakWheelsCertifiedCarsPage;
import pages.PakWheelsRepositoriesPage;
import utils.DriverManager;
import org.openqa.selenium.WebDriver;

public class PakWheelsSteps {

    private WebDriver driver = DriverManager.getDriver();
    private GoogleSearchPage googleSearchPage = new GoogleSearchPage(driver);
    private PakWheelsHomePage pakWheelsHomePage = new PakWheelsHomePage(driver);
    private PakWheelsCertifiedCarsPage pakWheelsCertifiedCarsPage = new PakWheelsCertifiedCarsPage(driver);
    private PakWheelsRepositoriesPage pakWheelsRepositoriesPage = new PakWheelsRepositoriesPage(driver);

    @Given("user is on google search page")
    public void user_is_on_google_search_page() {
        googleSearchPage.navigateToGoogle("https://www.google.com/");
    }

    @When("user searches for {string}")
    public void user_searches_for(String searchTerm) {
        googleSearchPage.searchFor(searchTerm);
    }

    @And("user clicks on the pakwheels link")
    public void user_clicks_on_the_pakwheels_link() {
        googleSearchPage.clickPakWheelsLink();
    }

    @And("user clicks on certified cars")
    public void user_clicks_on_certified_cars() {
        pakWheelsHomePage.clickCertifiedCars();
    }

    @And("user clicks on repositories")
    public void user_clicks_on_repositories() {
        pakWheelsCertifiedCarsPage.clickRepositories();
    }

    @And("user clicks on setup button")
    public void user_clicks_on_setup_button() {
        pakWheelsRepositoriesPage.clickSetupButton();
    }

    @Then("the navigation flow is completed")
    public void the_navigation_flow_is_completed() {
        // This step confirms the navigation flow has executed without errors.
        // In a real test, this would be an assertion on the final page state.
        System.out.println("Navigation flow completed successfully.");
    }
}
