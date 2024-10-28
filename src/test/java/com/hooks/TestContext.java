package com.hooks;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pageObject.ClassModule;
import com.utilities.ReadConfig;



public class TestContext {
	
	private WebDriver driver;
    private DriverFactory driverFactory;
    private WebDriverWait wait;
    private ReadConfig readConfig;
    private ClassModule cp;
    Actions action;
    
	// initializing the DriverFactory
    public TestContext() {
       this.driverFactory = new DriverFactory();
        this.readConfig = new ReadConfig();        
       
    }  
    public void setDriver(WebDriver driver) {
        this.driver = driver;
       // this.js=(JavascriptExecutor) driver;
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
    
    public Actions performAction() {
    	return action;
    }

    public String getApplicationURL() {
        return readConfig.getApplicationURL(); // Method to get URL
    }
    
    public ClassModule getClassModule() {
    	return cp;
    }

}
