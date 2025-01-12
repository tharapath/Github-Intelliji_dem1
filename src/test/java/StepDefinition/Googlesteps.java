package StepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Googlesteps {
    WebDriver driver;

        @Given("I open the browser")
        public void i_open_the_browser() {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
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

        }
    @Given("I am on the Google homepage")
        public void iAmOnTheGoogleHomepage() {

            driver.get("https://www.google.com");
        }

        @When("I search for {string}")
        public void iSearchFor(String searchValue) {
            driver.findElement(By.id("APjFqb")).sendKeys(searchValue);
            driver.findElement(By.id("APjFqb")).submit();
        }

        @Then("I should see search results for {string}")
        public void iShouldSeeSearchResultsFor(String searchValue) throws InterruptedException {
            List<WebElement> searchResultsElementsList = driver.findElements(By.xpath("//div[@id='rcnt']//span/a/h3"));
            // for (WebElement element : searchResultsElementsList)
            for (int i = 0; i <= searchResultsElementsList.size() - 1; i++) {

                System.out.println(searchResultsElementsList.get(i).getText());
            }
            Thread.sleep(10000);
            System.out.println(searchResultsElementsList.get(0).getText());
            Assert.assertTrue(searchResultsElementsList.get(0).getText().toLowerCase().contains(searchValue.toLowerCase()));

        }




//   @After
//    public void iCloseBrowser(Scenario scenario) throws IOException {
//       if(scenario.isFailed()){
//           File screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//           FileUtils.copyFile(screenShot,new File(scenario.getName()+ "screenshot.jpg"));
//
//       }
//
//
//       driver.quit();
//    }


//    @Before
//    public void launchBrowser(){
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//    }

    }
