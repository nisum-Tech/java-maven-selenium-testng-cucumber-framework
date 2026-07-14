package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OlxSearchResultsPage extends BasePage {

    By vehiclesInPakistan = By.cssSelector("header:nth-of-type(2) > div > div > div:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(1) > div:nth-of-type(2)");
    By vehicleSubCategory = By.xpath("//span[normalize-space()='(36,180)']");
    By genericElement = By.cssSelector("div");
    By gulshanEIqbalTown = By.xpath("//span[normalize-space()='Gulshan-e-Iqbal Town']");
    By searchResult = By.cssSelector("li:nth-of-type(10) > article > div:nth-of-type(2) > div > a > div");

    public OlxSearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public void hoverVehiclesInPakistan() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(vehiclesInPakistan));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

    public void clickVehicleSubCategory() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(vehicleSubCategory)).click();
    }

    public void hoverGenericElement() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(genericElement));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

    public void clickGulshanEIqbalTown() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(gulshanEIqbalTown)).click();
    }

    public void clickSearchResult() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(searchResult)).click();
    }
}
