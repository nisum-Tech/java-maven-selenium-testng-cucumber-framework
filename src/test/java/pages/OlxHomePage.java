package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OlxHomePage extends BasePage {

    private final By mobilesCategory = By.cssSelector("a:nth-of-type(1) > div > div > img");

    public OlxHomePage(WebDriver driver) {
        super(driver);
    }

    public void navigateToHomePage() {
        driver.get("https://www.olx.com.pk");
    }

    public void clickMobilesCategory() {
        driver.findElement(mobilesCategory).click();
    }
}
