package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class BeallsSearchResultsPage extends BasePage {

    By pageHeading = By.xpath("//*[@id='content']/div[2]/h1");
    By resultCount = By.xpath("//*[@id='content']/div[2]/div/div[2]/div");
    By addToBagButton = By.xpath(".//button[text()='Add to bag']");
    By addedPopup = By.xpath("//*[contains(text(),'Added')]");

    public BeallsSearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public void waitForSearchResultsPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(pageHeading));
    }

    public String getPageHeadingText() {
        return driver.findElement(pageHeading).getText();
    }

    public int getResultCount() {
        String text = driver.findElement(resultCount).getText();
        return Integer.parseInt(text.split(" ")[0].replace(""", ""));
    }

    public void waitForAddToBagButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(addToBagButton));
    }

    public void scrollAndClickAddToBag() {
        WebElement button = driver.findElement(addToBagButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", button);
        waitAndClick(button);
    }

    public boolean isAddedPopupVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(addedPopup)).isDisplayed();
    }

    public void waitForAddedPopupToDisappear() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(addedPopup));
    }
    
    private void waitAndClick(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }
}
