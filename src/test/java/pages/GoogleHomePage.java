package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class GoogleHomePage extends BasePage {

    By searchInput = By.id("APjFqb");

    public GoogleHomePage(WebDriver driver) {
        super(driver);
    }

    public void navigateTo(String url) {
        driver.get(url);
    }

    public void searchFor(String searchText) {
        driver.findElement(searchInput).sendKeys(searchText);
        driver.findElement(searchInput).sendKeys(Keys.ENTER);
    }
}
