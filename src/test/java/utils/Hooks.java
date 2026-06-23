package utils;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    @Before
    public void setup() {
        DriverManager.getDriver();
    }

    @After
    public void teardown() {
        DriverManager.quitDriver();
    }
}
