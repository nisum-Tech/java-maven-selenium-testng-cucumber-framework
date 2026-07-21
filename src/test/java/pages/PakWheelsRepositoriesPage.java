package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PakWheelsRepositoriesPage extends BasePage {

    By setupButton = By.xpath("//button[normalize-space()='Set up →']");

    public PakWheelsRepositoriesPage(WebDriver driver) {
        super(driver);
    }

    public void clickSetupButton() {
        driver.findElement(setupButton).click();
    }
}
