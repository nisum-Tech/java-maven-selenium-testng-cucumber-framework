package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class NisumHomePage extends BasePage {

    By digitalStrategyLink = By.xpath("//h5[normalize-space()='Digital Strategy & Transformation']");

    public NisumHomePage(WebDriver driver) {
        super(driver);
    }

    public void clickDigitalStrategyLink() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(digitalStrategyLink)).click();
    }
}
