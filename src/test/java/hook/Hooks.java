package hook;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utilities.ConfigReader;
import utilities.DriverManager;

import java.io.IOException;

public class Hooks {
    private WebDriver driver;

    // Cucumber Hooks
    @BeforeAll
    public static void beforeAll() {
    }

    @AfterAll
    public static void afterAll() {
    }

    @Before()
    public void beforeScenario(Scenario scenario) {

        System.out.println(scenario.getName()+" isimli Senaryo Çalıştı");
    }

    @After()
    public void afterScenario(Scenario scenario) {
        // Cucumber after hook code
        DriverManager.quitDriver();
        if (scenario.isFailed()) {
            ExtentCucumberAdapter.getCurrentStep().log(Status.FAIL, MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64Screenshot()).build());
        }
    }

        
        
    public String getBase64Screenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
    }

}