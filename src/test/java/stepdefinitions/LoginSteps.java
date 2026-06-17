
package stepdefinitions;

import io.cucumber.java.en.*;
import pages.LoginPage;
import utils.DriverManager;

public class LoginSteps {

    LoginPage login = new LoginPage(DriverManager.getDriver());

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
        System.out.println("Logged in");
    }
}
