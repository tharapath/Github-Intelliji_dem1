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
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class DemoQaSteps {
    WebDriver driver;

    @Given("I am on DemoQAbuttons page")
    public void iAmOnDemoQAbuttonsPage() {
        driver.get("https://demoqa.com/buttons");

    }

    @When("I click on the Double click button")
    public void iClickOnTheDoubleClickButton() throws InterruptedException {
        Actions actions = new Actions(driver);
        WebElement targetElement = driver.findElement(By.xpath("//button[@id='doubleClickBtn']"));
        actions.doubleClick(targetElement).perform();
        Thread.sleep(3000);
    }

    @Then("I see You have done Double click text")
    public void iSeeYouHaveDoneDoubleClickText() {
        String doubleClickText = driver.findElement(By.id("doubleClickMessage")).getText();
        Assert.assertEquals("Double click text not matching with expected","You have done a double click",doubleClickText);
    }

    @When("I click on the Right click button")
    public void iClickOnTheRightClickButton() {
    }

    @Then("I see You have done a Right click text")
    public void iSeeYouHaveDoneARightClickText() {
    }

    @When("I click on the Click Me button")
    public void iClickOnTheClickMeButton() {
    }

    @Then("I see You have done a dynamic click text")
    public void iSeeYouHaveDoneADynamicClickText() {
    }

    @After
    public void iCloseBrowser(Scenario scenario) throws IOException {
       if(scenario.isFailed()){
           File screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
           FileUtils.copyFile(screenShot,new File(scenario.getName()+ "screenshot.jpg"));
       }
       driver.quit();
    }


    @Before
    public void launchBrowser(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

}
