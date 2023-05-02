package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.DriverManager;

public class Hepsiburada {

    private WebDriver driver;

    public Hepsiburada(WebDriver driver) {
        this.driver = driver;

    }

    By searchBox = By.id("com.pozitron.hepsiburada:id/etSearchBox");
    By macbook = By.id("com.pozitron.hepsiburada:id/search_suggestion_title");

        
        
    public void searchInputClick(){

        driver.findElement(searchBox).click();
        driver.findElement(searchBox).sendKeys("macbook");
        driver.findElement(macbook).click();



    }

        
        
        
        
        
        
}