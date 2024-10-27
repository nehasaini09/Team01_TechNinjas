package com.hooks;
import org.openqa.selenium.interactions.Actions;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pageObject.BatchModule;
import com.utilities.ReadConfig;



public class TestContext {
	
	private WebDriver driver;
    private DriverFactory driverFactory;
    private WebDriverWait wait;
    private ReadConfig readConfig;
    private BatchModule batchModule;
    private Actions actions;
    
 // initializing the DriverFactory
    public TestContext() {
       this.driverFactory = new DriverFactory();
       //this.driver = driverFactory.initialiseBrowser("chrome"); 
       //this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
       this.readConfig = new ReadConfig(); // config reader initilise
       //this.batchModule = new BatchModule(driver);
    
    }  
    public void setDriver(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30)); 
        this.actions = new Actions(driver); // Initialize Actions here, after driver is set
        this.batchModule = new BatchModule(driver, this);
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

   // public BatchModule getBatchModule() {
    //    return batchModule; // Getter for BatchModule
    //}
    public Actions getActions() {
        return actions;
    }
    public BatchModule getBatchModule() {
        return batchModule; // Getter for BatchModule
    }
}
