package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PakWheelsCertifiedCarsPage extends BasePage {

    By repositoriesLink = By.xpath("//span[normalize-space()='Repositories']");

    public PakWheelsCertifiedCarsPage(WebDriver driver) {
        super(driver);
    }

    public void clickRepositories() {
        driver.findElement(repositoriesLink).click();
    }
}
