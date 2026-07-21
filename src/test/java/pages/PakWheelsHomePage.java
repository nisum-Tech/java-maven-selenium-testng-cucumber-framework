package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PakWheelsHomePage extends BasePage {

    By certifiedCarsLink = By.xpath("//strong[normalize-space()='PakWheels Certified Cars']");

    public PakWheelsHomePage(WebDriver driver) {
        super(driver);
    }

    public void clickCertifiedCars() {
        driver.findElement(certifiedCarsLink).click();
    }
}
