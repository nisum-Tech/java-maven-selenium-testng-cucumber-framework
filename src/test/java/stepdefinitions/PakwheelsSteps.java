package stepdefinitions;

import io.cucumber.java.en.*;
import pages.PakwheelsHomePage;
import utils.DriverManager;
import org.testng.Assert;

public class PakwheelsSteps {

    PakwheelsHomePage pakwheelsHomePage = new PakwheelsHomePage(DriverManager.getDriver());

    @Given("user navigates to {string}")
    public void userNavigatesTo(String url) {
        DriverManager.getDriver().get(url);
    }

    @When("user clicks \"Find Used Cars for Sale\"")
    public void userClicksFindUsedCarsForSale() {
        pakwheelsHomePage.clickFindUsedCarsForSale();
    }

    @When("user clicks \"Lahore 17,881\" field")
    public void userClicksLahoreField() {
        pakwheelsHomePage.clickLahoreField();
    }

    @And("user clicks \"Johar Town 1,283\" field")
    public void userClicksJoharTownField() {
        pakwheelsHomePage.clickJoharTownField();
    }

    @When("user clicks \"Toyota 336\" field")
    public void userClicksToyotaField() {
        pakwheelsHomePage.clickToyotaField();
    }

    @Then("a new tab should open with title {string}")
    public void aNewTabShouldOpenWithTitle(String expectedTitle) {
        String actualTitle = pakwheelsHomePage.switchToNewTabAndGetTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "New tab title mismatch");
    }
}
