package utilities;

        
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class DriverManager {

    private  static WebDriver driver;

        
    private DriverManager() {
    }
    public static WebDriver getDriver() {
        String browser = ConfigReader.getProperty("browser");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        if (driver==null){
            switch (browser){
                case "android":
                    capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
                    capabilities.setCapability("appPackage", "com.pozitron.hepsiburada");
                    capabilities.setCapability("appActivity", "com.hepsiburada.ui.home.BottomNavigationActivity");
                    capabilities.setCapability(MobileCapabilityType.FULL_RESET, false);
                    capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
                    capabilities.setCapability("unlockType", "pattern");
                    try {
                        driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
                    } catch (MalformedURLException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case "ios":
                    capabilities.setCapability("platformName", "iOS");
                    try {
                        driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
                    } catch (MalformedURLException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                default:
                    throw new RuntimeException("Invalid browser type provided!");
            }

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver;
    }

    public static void quitDriver() {
        if (driver!=null){
            driver.quit();
            driver=null;
        }
    }
}