package StepDefinition;

    import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

    public class GoogleSteps {
        WebDriver driver;

        @Given("I open the browser")
        public void i_open_the_browser() {
            WebDriverManager.chromedriver().setup(); // Set up ChromeDriver
            driver = new ChromeDriver(); // Launch Chrome
            driver.manage().window().maximize(); // Maximize browser window
        }

        @When("I navigate to Google")
        public void i_navigate_to_google() {
            driver.get("https://www.google.com"); // Navigate to Google
        }

        @Then("I should see the Google homepage")
        public void i_should_see_the_google_homepage() {
            String pageTitle = driver.getTitle(); // Get the page title
            if (!pageTitle.equals("Google")) {
                throw new AssertionError("Expected title: 'Google' but got: " + pageTitle);
            }
            driver.quit(); // Close the browser
        }
    }

