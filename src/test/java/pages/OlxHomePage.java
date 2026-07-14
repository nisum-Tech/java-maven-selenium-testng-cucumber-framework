package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OlxHomePage extends BasePage {

    By vehiclesCategory = By.cssSelector("a:nth-of-type(2) > div > div > img");

    public OlxHomePage(WebDriver driver) {
        super(driver);
    }

    public void navigateToHomePage() {
        driver.get("https://www.olx.com.pk");
    }

    public void clickVehiclesCategory() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(vehiclesCategory)).click();
    }
}
