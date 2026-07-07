package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.Set;

public class PakwheelsHomePage extends BasePage {

    // Locators
    By findUsedCarsForSale = By.xpath("//strong[normalize-space()='Find Used Cars for Sale']");
    By lahoreField = By.xpath("//label[normalize-space()='Lahore 17,881']//input");
    By joharTownField = By.xpath("//label[normalize-space()='Johar Town 1,283']//input");
    By toyotaField = By.xpath("//label[normalize-space()='Toyota 336']//input");

    public PakwheelsHomePage(WebDriver driver) {
        super(driver);
    }

    public void clickFindUsedCarsForSale() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(findUsedCarsForSale)).click();
    }

    public void clickLahoreField() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(lahoreField)).click();
    }

    public void clickJoharTownField() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(joharTownField)).click();
    }

    public void clickToyotaField() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(toyotaField)).click();
    }

    public String switchToNewTabAndGetTitle() {
        String originalWindow = driver.getWindowHandle();
        Set<String> allWindows = driver.getWindowHandles();
        String newWindowHandle = null;

        for (String windowHandle : allWindows) {
            if (!originalWindow.contentEquals(windowHandle)) {
                newWindowHandle = windowHandle;
                break;
            }
        }

        if (newWindowHandle != null) {
            driver.switchTo().window(newWindowHandle);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            wait.until(ExpectedConditions.not(ExpectedConditions.titleIs("About Blank")));
            return driver.getTitle();
        } else {
            throw new RuntimeException("New tab did not open.");
        }
    }
}
