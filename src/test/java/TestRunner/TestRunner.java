package TestRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.openqa.selenium.chrome.ChromeDriver;

@RunWith(Cucumber.class)
@CucumberOptions(

        features = "src/test/Resources1/GoogleSearch.feature",
        glue = "StepDefinition",
        plugin = {"pretty","html:target/cucumber-reports.html"},
        monochrome = true
)
public class TestRunner {


}
