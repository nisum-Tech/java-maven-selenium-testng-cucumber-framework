
package stepdefinitions;

import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.LoginPage;
import utils.DriverManager;

public class LoginSteps {

    LoginPage loginPage = new LoginPage(DriverManager.getDriver());

    @Given("user is on login page")
    public void openLogin() {
        DriverManager.getDriver().get("https://the-internet.herokuapp.com/login");
    }

    @When("user logs in")
    public void loginUser() {
        loginPage.login("tomsmith", "SuperSecretPassword!");
    }

    @Then("user should login successfully")
    public void verify() {
        Assert.assertTrue(loginPage.isLoginSuccessful(), "Login failed: success message not found");
    }
}
