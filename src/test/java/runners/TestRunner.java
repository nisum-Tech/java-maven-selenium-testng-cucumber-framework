package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "stepdefinitions",
        tags = "@olxUI or @api", // Running both so existing tests are not broken
        plugin = {"pretty", "html:target/cucumber-reports.html"}
)
public class TestRunner {
}
