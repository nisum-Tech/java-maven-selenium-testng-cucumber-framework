package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;

public class NisumDigitalStrategyPage extends BasePage {

    By pageHeading = By.xpath("//h1[normalize-space()='Digital Strategy & Transformation']");

    public NisumDigitalStrategyPage(WebDriver driver) {
        super(driver);
    }

    public void verifyPageHeadingIsVisible() {
        WebElement headingElement = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(pageHeading));
        Assert.assertTrue(headingElement.isDisplayed(), "Page heading is not visible.");
    }
}
