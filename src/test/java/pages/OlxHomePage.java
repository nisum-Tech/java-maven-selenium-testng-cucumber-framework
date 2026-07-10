package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OlxHomePage extends BasePage {

    // Locators from plan assumptions
    By bikesImage = By.xpath("//a[@href='/bikes/']"); // More specific than just by alt text
    By someElement = By.id("someGenericElementId"); // Placeholder
    By emailField = By.xpath("//input[@type='email'] | //*[contains(text(), 'Email')]"); // Placeholder

    public OlxHomePage(WebDriver driver) {
        super(driver);
    }

    public void clickBikesLink() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(bikesImage)).click();
    }

    public void clickSomeElement() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(someElement)).click();
    }

    public boolean isEmailFieldVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(emailField)).isDisplayed();
    }
}
