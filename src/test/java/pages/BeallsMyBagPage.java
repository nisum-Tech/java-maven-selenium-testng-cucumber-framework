package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class BeallsMyBagPage extends BasePage {

    By bagIcon = By.xpath("/html/body/header/nav/div/div/div[1]/div[2]/div/ul/li[3]/div/div/a");
    By pageHeading = By.xpath("//*[@id='content']/div[3]/h1");
    By bagProductCount = By.xpath("//*[@id='content']/div[3]/h1/span");
    By checkoutAsGuestButton = By.xpath("//*[@id='content']/div[3]/div[1]/div/div[3]/button[2]");

    public BeallsMyBagPage(WebDriver driver) {
        super(driver);
    }

    public void scrollAndClickBagIcon() {
        WebElement icon = driver.findElement(bagIcon);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", icon);
        waitAndClick(icon);
    }

    public void waitForMyBagPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(pageHeading));
    }

    public String getPageHeadingText() {
        return driver.findElement(pageHeading).getText();
    }

    public int getBagProductCount() {
        String text = driver.findElement(bagProductCount).getText();
        return Integer.parseInt(text.replaceAll("[()]", ""));
    }

    public void waitForCheckoutAsGuestButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(checkoutAsGuestButton));
    }

    public void scrollAndClickCheckoutAsGuest() {
        WebElement button = driver.findElement(checkoutAsGuestButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", button);
        waitAndClick(button);
    }
    
    private void waitAndClick(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }
}
