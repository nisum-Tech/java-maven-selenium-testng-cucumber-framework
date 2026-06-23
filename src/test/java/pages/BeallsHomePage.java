package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class BeallsHomePage extends BasePage {

    By searchInput = By.id("autocomplete-input");

    public BeallsHomePage(WebDriver driver) {
        super(driver);
    }

    public void navigateTo(String url) {
        driver.get(url);
    }

    public void enterSearchKeyword(String keyword) {
        driver.findElement(searchInput).sendKeys(keyword);
    }

    public void pressEnterToSearch() {
        driver.findElement(searchInput).sendKeys(Keys.ENTER);
    }
}
