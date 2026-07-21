package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OlxMobilesCategoryPage extends BasePage {

    private final By mobilePhonesSubCategory = By.xpath("//span[normalize-space()='Mobile Phones']");
    private final By karachiLocation = By.xpath("//span[normalize-space()='(30,419)']");
    private final By gulshanEIqbalLocation = By.xpath("//span[normalize-space()='Gulshan-e-Iqbal Town']");
    private final By resultsHeader = By.xpath("//h1");

    public OlxMobilesCategoryPage(WebDriver driver) {
        super(driver);
    }

    public void clickMobilePhonesSubCategory() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(mobilePhonesSubCategory)).click();
    }

    public void selectKarachi() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(karachiLocation)).click();
    }

    public void selectGulshanEIqbal() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(gulshanEIqbalLocation)).click();
    }

    public boolean isResultsPageVisible() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(resultsHeader));
        return driver.findElement(resultsHeader).getText().contains("Mobile Phones in Gulshan-e-Iqbal Town");
    }
}
