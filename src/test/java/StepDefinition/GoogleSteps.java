package StepDefinition;

    import io.cucumber.java.en.*;
    import org.openqa.selenium.By;
    import org.openqa.selenium.WebDriver;
    import org.openqa.selenium.WebElement;
    import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

    public class GoogleSteps {
        WebDriver driver;

        @Given("I open the browser")
        public void i_open_the_browser() {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(); // Launch Chrome
            driver.manage().window().maximize();
        }

        @When("I navigate to Google")
        public void i_navigate_to_google() {
            driver.get("https://www.google.com");  }

        @Then("I should see the Google homepage")
        public void i_should_see_the_google_homepage() {
            String pageTitle = driver.getTitle(); 
            if (!pageTitle.equals("Google")) {
                throw new AssertionError("Expected title: 'Google' but got: " + pageTitle);
            }
            driver.quit(); // Close the browser
        }
    }


class GoogleSearchSteps {
    WebDriver driver;

    @Given("I am on the Google homepage")
    public void i_am_on_the_google_homepage() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.google.com");
    }

    @When("I search for {string}")
    public void i_search_for(String searchTerm) {
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys(searchTerm);
        searchBox.submit();
    }

    @Then("I should see search results for {string}")
    public void i_should_see_search_results_for(String searchTerm) {
        WebElement results = driver.findElement(By.id("search"));
        assert results.getText().contains(searchTerm) : "Search results do not contain the term: " + searchTerm;
        driver.quit();
    }
}


