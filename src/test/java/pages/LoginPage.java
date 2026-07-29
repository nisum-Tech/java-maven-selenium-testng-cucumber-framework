
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage {

    By username = By.id("username");
    By password = By.id("password");
    By loginBtn = By.cssSelector("button[type='submit']");
    By flashMessage = By.id("flash");

    private final WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void login(String user, String pass) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(username)).sendKeys(user);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(loginBtn).click();
    }

    public boolean isLoginSuccessful() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(flashMessage))
                   .getText()
                   .contains("You logged into a secure area!");
    }
}
