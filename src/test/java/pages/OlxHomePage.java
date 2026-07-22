package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OlxHomePage extends BasePage {

    // Locators
    private By postAdButton = By.id("TODO_locator_for_post_ad_button"); // FIXME: Locator for 'Post an Ad' or 'Sell' button needed.

    public OlxHomePage(WebDriver driver) {
        super(driver);
    }

    public void navigateTo(String url) {
        driver.get(url);
    }

    public void login() {
        // FIXME: Login implementation is a placeholder.
        // This should navigate to a login page, enter credentials, and submit.
        System.out.println("Placeholder for user login. This step assumes user is already logged in or login can be achieved via cookies/API.");
    }

    public void clickPostAd() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(postAdButton)).click();
    }
}
