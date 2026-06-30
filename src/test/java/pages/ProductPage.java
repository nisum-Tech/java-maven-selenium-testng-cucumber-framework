package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage extends BasePage {

    By productOptionsSelect = By.id("product-select-6986769596469template--18308488003637__main");
    By addToCartButton = By.cssSelector(".t4s-product-form__submit");
    By confirmationMessage = By.xpath("//*[contains(text(),'added to your cart')]");

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void selectProductOption(String optionValue) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(productOptionsSelect));
        Select options = new Select(driver.findElement(productOptionsSelect));
        options.selectByValue(optionValue);
    }

    public void addToCart() {
        driver.findElement(addToCartButton).click();
    }

    public boolean isProductAddedToCart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(confirmationMessage)).isDisplayed();
    }
}
