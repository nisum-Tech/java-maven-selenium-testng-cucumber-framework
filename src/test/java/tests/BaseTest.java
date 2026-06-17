
package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.DriverManager;

public class BaseTest {

    @BeforeMethod
    public void setup(){
        DriverManager.getDriver();
    }

    @AfterMethod
    public void tearDown(){
        DriverManager.quitDriver();
    }
}
