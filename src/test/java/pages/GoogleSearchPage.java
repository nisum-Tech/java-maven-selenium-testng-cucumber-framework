package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GoogleSearchPage extends BasePage {

    By searchInput = By.id("APjFqb");
    By pakwheelsLink = By.xpath("//span[normalize-space()='Buy & Sell Cars, Bikes & Autoparts | Buy & Sell Cars']");

    public GoogleSearchPage(WebDriver driver) {
        super(driver);
    }

    public void navigateToGoogle(String url) {
        driver.get(url);
    }

    public void searchFor(String searchTerm) {
        driver.findElement(searchInput).sendKeys(searchTerm);
        driver.findElement(searchInput).submit();
    }

    public void clickPakWheelsLink() {
        driver.findElement(pakwheelsLink).click();
    }
}
