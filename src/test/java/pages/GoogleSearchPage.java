package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class GoogleSearchPage extends BasePage {

    By searchBox = By.id("APjFqb");
    By nisumLink = By.partialLinkText("Nisum | A Technology Consulting Partner");

    public GoogleSearchPage(WebDriver driver) {
        super(driver);
    }

    public void navigateToGoogle() {
        driver.get("https://www.google.com");
    }

    public void searchFor(String searchTerm) {
        driver.findElement(searchBox).sendKeys(searchTerm);
        driver.findElement(searchBox).sendKeys(Keys.RETURN);
    }

    public void clickNisumLink() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(nisumLink)).click();
    }
}
