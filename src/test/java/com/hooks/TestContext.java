package com.hooks;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.utilities.ReadConfig;



public class TestContext {
	
	private WebDriver driver;
    private DriverFactory driverFactory;
    private WebDriverWait wait;
    private ReadConfig readConfig;
    
 // initializing the DriverFactory
    public TestContext() {
       this.driverFactory = new DriverFactory();
       //this.driver = driverFactory.initialiseBrowser("chrome"); 
       //this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
       this.readConfig = new ReadConfig(); // config reader initilise
       
    }  
    public void setDriver(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30)); 
    }
    public DriverFactory getDriverFactory() {
        return driverFactory;
    }
 // WebDriver instance
    public WebDriver getDriver() {
        return driver;
    }  
// driver close
    public void closeDriver() {
        driverFactory.closeDriver();
    }
    public WebDriverWait getWait() {
        return wait;
    }

    public String getApplicationURL() {
        return readConfig.getApplicationURL(); // Method to get URL
    }

}