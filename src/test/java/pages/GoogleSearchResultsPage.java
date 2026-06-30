package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GoogleSearchResultsPage extends BasePage {

    // This locator is from the recording and might be brittle.
    By productLink = By.cssSelector("div:nth-of-type(6) > div > div:nth-of-type(1) > a");

    public GoogleSearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public void clickSearchResultByText(String resultText) {
        By resultLink = By.xpath("//h3[contains(text(),''''' + resultText + ''''')]");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(resultLink)).click();
    }
    
    public void clickProductLink() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(productLink)).click();
    }
}
