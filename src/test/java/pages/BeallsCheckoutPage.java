package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class BeallsCheckoutPage extends BasePage {

    By pageHeading = By.xpath("//*[@id='content']/h1");

    public BeallsCheckoutPage(WebDriver driver) {
        super(driver);
    }

    public void waitForCheckoutPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(pageHeading));
    }

    public String getPageHeadingText() {
        return driver.findElement(pageHeading).getText();
    }
}
